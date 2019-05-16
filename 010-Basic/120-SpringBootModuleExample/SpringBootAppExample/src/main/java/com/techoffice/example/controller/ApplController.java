package com.techoffice.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplController {

	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }
}
