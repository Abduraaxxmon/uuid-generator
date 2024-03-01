package com.example.uuid.Controller;

import com.example.uuid.Servise.UuidGenerator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;
import java.util.UUID;

@RestController
@RequestMapping("/generatekey")
public class NewController {
    @Autowired
    private UuidGenerator generator;
    @GetMapping
    public String getBy(HttpServletRequest request){
        return generator.generate(request.getRemoteAddr());
    }
}
