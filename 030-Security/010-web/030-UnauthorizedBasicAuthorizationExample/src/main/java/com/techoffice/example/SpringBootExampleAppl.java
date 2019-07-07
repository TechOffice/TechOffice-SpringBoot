package com.techoffice.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@EnableAutoConfiguration
public class SpringBootExampleAppl {

	@RequestMapping("/")
    ResponseEntity home() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(HttpHeaders.WWW_AUTHENTICATE, "Basic realm=\"TechOffice\"");
        ResponseEntity<String> responseEntity = new ResponseEntity<String>(responseHeaders, HttpStatus.UNAUTHORIZED);
        return responseEntity;
    }
	
	public static void main(String[] args){
        SpringApplication.run(SpringBootExampleAppl.class, args);
	}
}
