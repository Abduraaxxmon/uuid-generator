package com.example.uuid.Servise;

import com.example.uuid.Entity.User;
import com.example.uuid.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UuidGenerator {
    @Autowired
    private UserRepository repository;
    public String generate(String url){
        String uuid=UUID.randomUUID().toString();
        User user= new User();
        user.setDate(LocalDateTime.now().now());
        user.setApiAddress(url);
        user.setGenerateUuid(uuid);
        repository.save(user);

        return uuid;
    }
}
