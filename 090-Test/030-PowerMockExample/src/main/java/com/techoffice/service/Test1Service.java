package com.techoffice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Test1Service {

    @Autowired
    private Test2Service test2Service;

    public String returnFromTest2Service() {
        return test2Service.returnTestingString();
    }

    public String returnFromPrivateMethod(){
        return privateMethod();
    }

    private String privateMethod() {
        return "private value";
    }
}
