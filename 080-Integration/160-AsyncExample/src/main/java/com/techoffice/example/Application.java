package com.techoffice.example;

import com.techoffice.example.service.AsyncService;
import com.techoffice.example.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableAsync
public class Application {

    @Autowired
    private SyncService syncService;

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/getSyncResult")
    String getSyncResult() {
        return syncService.getAsyncTestResult();
    }

    @RequestMapping("/getAsyncResult")
    String getAsyncResult() {
        asyncService.getTestResult();
        return "Done";
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
