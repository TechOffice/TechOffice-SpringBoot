package com.techoffice.service;

import org.springframework.messaging.MessageHeaders;

import java.util.List;

public interface TestService {
    List<String> getSourceStringList();

    List<String> logSourceStringList(List<String> sourceStringList, MessageHeaders headers);

    List<String> logSourceStringList2(List<String> sourceStringList, MessageHeaders headers);

    String handle(String input, MessageHeaders headers);
}
