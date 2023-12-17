package com.learnFromYT.SpringBootYT.Controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @Value("${some.config.message}")
    private String message;

    @GetMapping("/")
    public String helloWorld(){
        return message;
    }
}
