package com.techoffice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplController {

	@RequestMapping("/")
    String home(HttpSession session) {
        return session.getId();
    }
	
	@RequestMapping("/access")
	String access(){
		return "access";
	}
}
