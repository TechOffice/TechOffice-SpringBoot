package com.techoffice.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({
	"com.techoffice.example",
	"com.techoffice.module1",
	"com.techoffice.module2"
})
@SpringBootApplication
public class Appl {
		
	public static void main(String[] args){
        SpringApplication.run(Appl.class, args);
	}
}
