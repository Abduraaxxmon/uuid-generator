package com.example.uuid.Servise;

import com.example.uuid.Handler.GenerateSecretKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecretGenerateService {
    public String generate(){
        return GenerateSecretKey.generate();
    }

}
