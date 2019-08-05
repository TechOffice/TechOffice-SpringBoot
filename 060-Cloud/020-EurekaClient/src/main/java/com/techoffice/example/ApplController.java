package com.techoffice.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class ApplController {

    @RequestMapping("/")
    @ResponseBody
    public String home(){
        return "Hello World";
    }

}
