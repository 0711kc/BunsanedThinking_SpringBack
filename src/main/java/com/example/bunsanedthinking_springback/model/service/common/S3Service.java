package com.example.bunsanedthinking_springback.model.service.common;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class S3Service {
    private final AmazonS3Client s3Client;

    @Value("${aws.s3.bucket}")
    private String bucket;

    public String upload(InputStream inputStream) throws IOException {
        String fileName = createFileName();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType("image/png");
        s3Client.putObject(bucket, fileName, inputStream, metadata);
        return fileName;
    }

    private String createFileName() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        return UUID.randomUUID() + "_" + LocalDateTime.now().format(formatter);
    }

    public String getObjectUrl(String objectKey) throws UnsupportedEncodingException {
        String region = "ap-northeast-2";
        String encodedKey = URLEncoder.encode(objectKey, "UTF-8");
        return String.format("https://%s.s3.%s.amazonaws.com/%s", bucket, region, encodedKey);
    }

    public String generatePresignedUrl(String objectKey, int durationInSeconds) {
        try (S3Presigner presigner = S3Presigner.create()) {
            GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                    .bucket(bucket)
                    .key(objectKey)
                    .build();
            GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                    .signatureDuration(Duration.ofSeconds(durationInSeconds))
                    .getObjectRequest(getObjectRequest)
                    .build();
            URL presignedUrl = presigner.presignGetObject(presignRequest).url();
            return presignedUrl.toString();
        }
    }

    public void delete(String objectKey) {
        try {
            s3Client.deleteObject(bucket, objectKey);
        } catch (SdkClientException e) {
            throw new IllegalStateException("[Error] AWS S3 서비스 접근에 실패했습니다.");
        }
    }
}
