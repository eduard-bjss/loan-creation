package com.bjss.accelerator.lambda;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

public class BucketStorage {
    private final String bucketName;
    private final String folder; // folder path in the bucket
    private final String contentType; // folder path in the bucket

    public BucketStorage(String bucketName, String folder, String contentType) {
        this.bucketName = bucketName;
        this.folder = folder.endsWith("/") ? folder : folder + "/";
        this.contentType = contentType;
    }

    public void uploadFile(String key, String content) {
       /* we need AWs credentials to pull from KMS
       Java System Properties - aws.accessKeyId and aws.secretAccessKey
        Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_ACCESS_KEY
        S3Client client = S3Client.builder()
                .credentialsProvider(AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(region)
                .build();

        */
        String objectKey = folder + key;
        try (S3Client client = S3Client.builder().build()) {
            PutObjectRequest request = PutObjectRequest.builder()
                    .bucket(bucketName).key(objectKey).contentType(contentType).build();
            client.putObject(request, RequestBody.fromString(content));
        }
    }
}
