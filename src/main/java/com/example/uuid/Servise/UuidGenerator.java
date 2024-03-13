package com.example.uuid.Servise;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UuidGenerator {
    public String generate(String url){
        String uuid=UUID.randomUUID().toString();
        return uuid;
    }
}
