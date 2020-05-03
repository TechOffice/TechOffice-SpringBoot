package com.techoffice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableResourceServer
public class Application {
	
	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }
	
	public static void main(String[] args){
        SpringApplication.run(Application.class, args);
	}
}
