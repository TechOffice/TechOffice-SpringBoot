package com.techoffice.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApplController {
	
	@RequestMapping("/")
	public String home(){
		return "home";
	}
}
