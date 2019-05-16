package com.techoffice;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Appl {
	
	@RequestMapping("/")
    String home(HttpSession session) {
        return session.getId();
    }
	
	public static void main(String[] args){
        SpringApplication.run(Appl.class, args);
	}
}
