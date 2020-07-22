package com.techoffice.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SyncService {

    @Autowired
    private AsyncService asyncService;

    public String getAsyncTestResult(){
        String result = "";
        try {
            result = asyncService.getTestResult().get();
        }catch (Exception e){
            log.error(e.getMessage(), e);
        }
        return result;
    }
}
