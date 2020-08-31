package com.techoffice.example;

import brave.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

@Slf4j
@RestController
@SpringBootApplication
public class SpringBootExampleAppl {

    @Autowired
    private Tracer tracer;

    @Autowired
    private MessagingService messagingService;

    @Autowired
    private ExecutorService executorService;

	@RequestMapping("/")
    public String home() {
	    String currentTraceId = tracer.currentSpan().context().traceIdString();
	    log.info("Logging From Http Request Thread, {}", currentTraceId);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                String currentTraceId = tracer.currentSpan().context().traceIdString();
                log.info("Logging From Backend Thread: {}", currentTraceId);
            }
        });

        return "Hello World!";
    }

    @RequestMapping("/2")
    public String home2() throws ExecutionException, InterruptedException {
        String currentTraceId = tracer.currentSpan().context().traceIdString();
        log.info("Logging From Http Request Thread, {}", currentTraceId);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> result = executorService.submit(new Callable<String>() {
            @Override
            public String call() {
                log.info("Logging From Backend Thread: {}");

                messagingService.send("Hello World from Http Request Thread (Aysnc)");

                return "completed";
            }
        });
        result.get();


        return "Hello World!";
    }


    @RequestMapping("/sendMessage")
    public String sendMessage(){
	    log.info("Send Message from Http Request Thread");
	    messagingService.send("Hello World from Http Request Thread");
        return "Sent Message";
    }


    @RequestMapping("/sendMessageAsync")
    public String sendMessageAsync(){
        log.info("Send Message from Http Request Thread (Async)");

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                String currentTraceId = tracer.currentSpan().context().traceIdString();
                log.info("Logging From Backend Thread: {}", currentTraceId);

                messagingService.send("Hello World from Http Request Thread (Aysnc)");

            }
        });

        return "Sent Message";
    }

	public static void main(String[] args){
        SpringApplication.run(SpringBootExampleAppl.class, args);
	}

	@Bean
	public ExecutorService executorService(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        return executorService;
    }
}
