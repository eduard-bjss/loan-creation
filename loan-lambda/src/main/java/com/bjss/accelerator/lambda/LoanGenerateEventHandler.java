package com.bjss.accelerator.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bjss.accelerator.domain.LambdaParameters;
import com.bjss.accelerator.domain.Loan;
import com.bjss.accelerator.generator.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoanGenerateEventHandler implements RequestHandler<LambdaParameters, List<String>> {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LoanGenerateEventHandler.class);

    @Override
    public List<String> handleRequest(LambdaParameters input, Context context) {
        int num = input.getLoanNumberToGenerate();
        log.info("Got request to generate {} loans", num);
        List<String> out = new ArrayList<>();
        BucketStorage bucketClient = null;
        if (input.getS3_bucket() != null) {
            bucketClient = new BucketStorage(input.getS3_bucket(), input.getS3_bucket_folder(), "application/json");
        }
        for (int i = 0; i < num; i++) {
            Loan loan = Generator.generateLoan();
            Optional<String> json = loan.toJson();
            json.ifPresent(out::add);
            if (bucketClient != null && json.isPresent()) {
                bucketClient.uploadFile(loan.getLoanId() + ".json", json.get());
            }
        }
        return out;
    }
}
