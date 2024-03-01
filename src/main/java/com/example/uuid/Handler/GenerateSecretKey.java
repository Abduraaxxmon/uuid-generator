package com.example.uuid.Handler;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Base64;
@Component
public class GenerateSecretKey {
    public static String generate() {
        // Create instance of SecureRandom
        SecureRandom random = new SecureRandom();
        
        // Generate a random byte array
        byte[] keyBytes = new byte[32]; // 256 bits for HMAC-SHA-256
        random.nextBytes(keyBytes);
        
        // Optionally, encode the byte array into a string format (e.g., Base64) for easier storage and usage
        String secretKey = Base64.getEncoder().encodeToString(keyBytes);
        
        // Print the generated key
        System.out.println("Secret Key: " + secretKey);
        return secretKey;
    }
}
