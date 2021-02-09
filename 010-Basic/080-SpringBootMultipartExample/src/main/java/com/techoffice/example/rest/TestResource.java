package com.techoffice.example.rest;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestResource {

    @Data
    public class TestModel{
        private String name;
    }


    public TestModel getTestData(){
        return new TestModel();
    }
}
