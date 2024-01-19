package com.dealdove.dealdove.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.util.Base64;

@RestController
public class ImageController {
    private final AmazonS3 amazonS3;

    public ImageController(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    @PostMapping("/product/imageUpload")
    public String uploadImage(@RequestBody ImageRequest imageRequest) {
        try {
            // 解碼base64字符串
            byte[] decodedBytes = Base64.getDecoder().decode(imageRequest.getImage());

            String objectKey = "uploaded_image_" + System.currentTimeMillis() + ".png";

            // 上傳到 S3
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(decodedBytes.length);
            amazonS3.listObjects("dealdove").getObjectSummaries().forEach(System.out::println);
            amazonS3.putObject(new PutObjectRequest("dealdove", objectKey, new ByteArrayInputStream(decodedBytes), metadata));

            return "Image processed successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error processing image";
        }
    }

    // 定義一個POJO來接收JSON請求
    public static class ImageRequest {
        private String image;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

}
