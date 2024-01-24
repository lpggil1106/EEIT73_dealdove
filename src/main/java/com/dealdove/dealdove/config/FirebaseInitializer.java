package com.dealdove.dealdove.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class FirebaseInitializer {

    public FirebaseInitializer() {
        System.out.println("FirebaseInitializer initializing...");
        try (InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("dealdoveFirebaseConfig.json")) {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://dealdove-36d8c-default-rtdb.asia-southeast1.firebasedatabase.app")
                    .build();
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println("FirebaseApp initialized successfully");
            } else {
                System.out.println("FirebaseApp 'DEFAULT' already exists, skipping initialization");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error initializing Firebase SDK", e);
        }
    }
}
