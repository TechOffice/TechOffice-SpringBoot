package com.techoffice.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techoffice.model.ResponseData;
import com.techoffice.security.config.WebSecurityConfig;
import com.techoffice.security.util.KeyUtil;

@EnableWebSecurity
@RestController
@SpringBootApplication
@ComponentScan("com.techoffice.security")
@Import(WebSecurityConfig.class)
public class Test1App {
	
	@RequestMapping("/")
    String home() {
        return "Test1 App";
    }
	
	@RequestMapping("/test")
	@ResponseBody
	public ResponseData<String> auth(){
		return new ResponseData<String>("authenticated");
	}
	
	@ResponseBody
	@RequestMapping(value="/key")
	public String getKey(){
		return KeyUtil.encodeKey();
	}
	
	public static void main(String[] args){
        SpringApplication.run(Test1App.class, args);
	}
}
