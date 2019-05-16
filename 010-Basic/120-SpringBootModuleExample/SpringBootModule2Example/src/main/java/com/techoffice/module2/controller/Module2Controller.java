package com.techoffice.module2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/module2")
@RestController
public class Module2Controller {

	@RequestMapping("/")
    String home() {
        return "Module2!";
    }
}
