package com.techoffice;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJms
public class SpringBootExampleAppl {
	
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("sample.queue");
	}

	public static void main(String[] args){
        SpringApplication.run(SpringBootExampleAppl.class, args);
	}
}
