package com.techoffice;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Appl {
	
	@RequestMapping("/")
    String home(HttpSession session) {
        return session.getId();
    }
	
	@RequestMapping("/setAttribute")
	String setAttribute(HttpSession session, @RequestParam("variable") String variable){
		session.setAttribute("variable", variable);
		return "set";
	}
	
	@RequestMapping("/getAttribtue")
	String getAttribtue(HttpSession session){
        return session.getAttribute("variable").toString();
	}
	
	public static void main(String[] args){
        SpringApplication.run(Appl.class, args);
	}
}
