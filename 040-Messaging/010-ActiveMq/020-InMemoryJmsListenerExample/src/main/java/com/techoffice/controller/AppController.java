package com.techoffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techoffice.messaging.Producer;

@RestController
public class AppController {
	
	@Autowired
	private Producer producer;
	
	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }
	
	@RequestMapping("/send")
	String send(){
		producer.send("Hello World");
		return "send";
	}
	
}
