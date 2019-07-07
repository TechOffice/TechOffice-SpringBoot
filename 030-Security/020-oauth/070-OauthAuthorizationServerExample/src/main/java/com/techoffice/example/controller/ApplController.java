package com.techoffice.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplController {

    @GetMapping("/")
    @ResponseBody
    public String home(){
        return "Hello World";
    }

}
