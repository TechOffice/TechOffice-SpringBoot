package com.techoffice.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableZuulProxy
@RestController
@SpringBootApplication
public class SpringBootExampleAppl {

	@RequestMapping("/")
    String home() {
        return "Proxy: Hello World!";
    }

    @RequestMapping("/test")
    String test() {
        return "Proxy: Hello World Test!";
    }
	
	public static void main(String[] args){
        SpringApplication.run(SpringBootExampleAppl.class, args);
	}

    @Bean
    public SimpleFilter simpleFilter() {
        return new SimpleFilter();
    }

}
