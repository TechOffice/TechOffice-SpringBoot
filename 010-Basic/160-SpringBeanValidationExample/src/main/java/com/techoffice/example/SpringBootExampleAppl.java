package com.techoffice.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@SpringBootApplication
@Validated
public class SpringBootExampleAppl {

    @RequestMapping("/echoTestModel")
    TestModel echoTestModel(@Valid @RequestBody TestModel testModel){
	    return testModel;
    }

	public static void main(String[] args){
        SpringApplication.run(SpringBootExampleAppl.class, args);
	}
}
