package com.bjss.accelerator.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class LambdaParameters {
    @JsonProperty("loans-number")
    private int loanNumberToGenerate;

    @JsonProperty("s3-bucket")
    private String s3_bucket;

    @JsonProperty("s3-bucket-folder")
    private String s3_bucket_folder;
}
