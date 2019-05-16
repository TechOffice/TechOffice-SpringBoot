package com.techoffice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Test2Service {

    @Autowired
    private Test1Service test1Service;

    public String returnTestingString(){
        return "testing";
    }

}
