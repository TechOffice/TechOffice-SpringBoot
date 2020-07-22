package com.techoffice.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class AsyncService {

    @Async
    public Future<String> getTestResult() {
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        log.info("Async Process Completed.");
        return new AsyncResult("Async Test Result");
    }

}
