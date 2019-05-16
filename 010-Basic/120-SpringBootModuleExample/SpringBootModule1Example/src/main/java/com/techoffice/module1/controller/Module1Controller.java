package com.techoffice.module1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/module1")
@RestController
public class Module1Controller {

	@RequestMapping("/")
    String home() {
        return "Module1!";
    }
}
