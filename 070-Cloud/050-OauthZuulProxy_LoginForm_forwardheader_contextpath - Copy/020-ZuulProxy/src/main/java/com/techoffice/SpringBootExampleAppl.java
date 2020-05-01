package com.techoffice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExampleAppl.class, args);
    }

}
