package com.techoffice.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplController {

    @RequestMapping("/")
    String home() {
        return "index";
    }

}
