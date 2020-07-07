package com.techoffice.rest.v0;

import com.techoffice.enums.TestType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v0/home")
public class HomeResource {

    @RequestMapping("getTestType/{testType}")
    public TestType getTestType(@PathVariable("testType") TestType testType){
        return testType;
    }

    @RequestMapping("getTestType1")
    public TestType getTestType1(){
        return TestType.TYPE1;
    }}
