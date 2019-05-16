package com.techoffice.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techoffice.security.model.ResponseData;

@Controller
public class SimpleController {
	
	@RequestMapping(value="/")
	public String home(){
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value="/access")
	public ResponseData<String> access(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null){
			System.out.println(authentication.getName() + ": authenticated" );
		}else{
			System.out.println("not authenticated");
		}
		return new ResponseData<String>("access");
	}
	
	@ResponseBody
	@RequestMapping(value="/auth")
	public ResponseData<String> auth(){
		return new ResponseData<String>("authenticated");
	}
}

