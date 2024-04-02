package com.fiktionmaps.fiktionmaps.config;

import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.env.Environment;


import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;


@Configuration
public class FirebaseConfiguration
{
    @Autowired
    private Environment env;
    @Autowired
    private ResourceLoader resourceLoader;


    @PostConstruct
    public void initialize() {
        try {
            String springProfile = env.getProperty("SPRING_PROFILE");
            String fileName = env.getProperty("FIREBASE_CONFIG_FILE_NAME");

            InputStream serviceAccount = getInputStream(springProfile, fileName);

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private InputStream getInputStream(String springProfile, String fileName) throws IOException {
        InputStream serviceAccount;
        if ("dev".equals(springProfile)) {
            Resource resource = resourceLoader.getResource("classpath:" + fileName);
            serviceAccount = resource.getInputStream();
        } else if ("prod".equals(springProfile)) {
            var s3Client = AmazonS3ClientBuilder.standard().withRegion("us-east-2").build();
            S3Object object = s3Client.getObject("fiktionmaps-settings", "serviceAccountKey.json");
            serviceAccount = object.getObjectContent();
        } else {
            throw new IllegalStateException("Spring profile is not configured correctly.");
        }
        return serviceAccount;
    }
}
