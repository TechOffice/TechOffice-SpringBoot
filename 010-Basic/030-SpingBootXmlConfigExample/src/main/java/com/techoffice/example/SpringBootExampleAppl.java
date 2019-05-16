package com.techoffice.example;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class SpringBootExampleAppl {
		
	public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(Config.class);
        HelloWorldExample helloWorldExample = context.getBean(HelloWorldExample.class);
        System.out.println(helloWorldExample.getMessage());
	}
}
