package com.techoffice.example.controller;

import com.techoffice.example.model.TestModel;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
public class HomeController {
    @RequestMapping("/echoTestModel")
    TestModel echoTestModel(@Valid @RequestBody TestModel testModel){
        return testModel;
    }
}
