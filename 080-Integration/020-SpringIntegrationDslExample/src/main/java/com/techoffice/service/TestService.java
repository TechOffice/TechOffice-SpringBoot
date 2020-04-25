package com.techoffice.service;

import org.springframework.messaging.MessageHeaders;

import java.util.List;

public interface TestService {
    List<String> getSourceStringList();

    String handle(String input, MessageHeaders headers);
}
