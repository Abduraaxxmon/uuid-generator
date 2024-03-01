package com.example.uuid.Controller;

import com.example.uuid.Servise.SecretGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("seckret")
public class SecretKeyController {
    @Autowired
    private SecretGenerateService service;
    @GetMapping
    public String generate(){
        return service.generate();
    }
}
