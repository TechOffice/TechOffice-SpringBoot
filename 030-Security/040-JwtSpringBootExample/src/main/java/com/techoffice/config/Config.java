package com.techoffice.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Value("${secretKey}")
	private String secretKey;
	
	@PostConstruct
	public void init(){
		System.out.println(secretKey);
	}
}
