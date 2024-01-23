package com.dealdove.dealdove.model;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {

    @Value("${aws.accessKeyId}")
    private String accessKeyId;

    @Value("${aws.secretKey}")
    private String secretKey;

    @Value("${aws.s3.region}")
    private String region;

    public AWSCredentials credentials() {
        AWSCredentials credentials = new BasicAWSCredentials(
                "AKIARQLKGSKVNEBVBLXF",
                "B9BKpwxeOn5GYHfEum1I+8XFQ3W/kUNfbLMs7o5K"
        );
        return credentials;
    }
    @Bean
    public AmazonS3 amazonS3() {
        try {
            // ... 其他配置 ...
            System.out.println("Creating AmazonS3 client");
            System.out.println(region);

            AmazonS3 s3client = AmazonS3ClientBuilder
                    .standard()
                    .withCredentials(new AWSStaticCredentialsProvider(credentials()))
                    .withRegion(Regions.AP_NORTHEAST_1)
                    .build();
            return s3client;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}