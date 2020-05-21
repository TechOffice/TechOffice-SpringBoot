package com.techoffice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Override
    public List<String> getSourceStringList() {
        List<String> sourceStringList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sourceStringList.add("Testing Content" + i);
        }
        return sourceStringList;
//        return new ArrayList<>();
    }

    @Override
    public List<String> logSourceStringList(List<String> sourceStringList, MessageHeaders headers) {
        log.info("Source String List Size: {}", sourceStringList.size());
        return sourceStringList;
    }

    @Override
    public List<String> logSourceStringList2(List<String> sourceStringList, MessageHeaders headers) {
        log.info("Aggregated String List Size 2: {}", sourceStringList.size());
        return sourceStringList;
    }

    @Override
    public String handle(String input, MessageHeaders headers) {
//        log.info("processing input: {}", input);
        if ("TESTING CONTENT3".equals(input.toUpperCase())){
//            throw new RuntimeException("Testing Runtime Exception");
            return input;
        }
//        return input;
        return null;
    }


}
