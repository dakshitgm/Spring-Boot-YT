package com.learnFromYT.SpringBootYT.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping("/")
    public String helloWorld(){
        return "Some text Autorunning";
    }
}
