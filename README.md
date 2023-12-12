# loan-creation
Project code to produce AWS Lambda that will generate Test data for the Loans. Lambda setup to accept three paramters in ta JSON format:
```
{
  "loans-number" : number, // number of loans to generate. Numeric
  "s3_bucket" : "bucket_name", // full bucket name. If present output will be saved in this bucket
  "s3-bucket-folder" : "folder_path" // subfolder full key name for the bucket where to save loans ex: "/loans/12/12/2023/"
}
```
Currently AWS supports JDK 17, so make sure set your project to use Java 17 (AWS Carretto preffered)
