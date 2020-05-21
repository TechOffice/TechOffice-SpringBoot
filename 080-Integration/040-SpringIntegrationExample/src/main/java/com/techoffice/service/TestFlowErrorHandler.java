package com.techoffice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

@Slf4j
@Component
public class TestFlowErrorHandler implements ErrorHandler {

    @Override
    public void handleError(Throwable throwable) {
        log.error("Test Flow Error Handler: {}", throwable.getMessage());
    }

}
