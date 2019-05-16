package com.techoffice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@RestController
public class ApplController {

	@RequestMapping("/")
    String home(HttpSession session) {
        return session.getId();
    }
	
}
