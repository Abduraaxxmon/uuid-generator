package com.example.uuid.Controller;

import com.example.uuid.Servise.UuidGenerator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/v1")
public class UuidGeneratorController {

    @GetMapping("api")
    public ModelAndView generate(HttpServletRequest request){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("uuidpage");
        return mv;
    }
}
