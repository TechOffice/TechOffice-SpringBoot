package com.techoffice.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApplController {

    @RequestMapping("/")
    String home() {
        return "index";
    }

    @RequestMapping("/testing")
    @ResponseBody
    String testing() {
        return "Testing";
    }

}
