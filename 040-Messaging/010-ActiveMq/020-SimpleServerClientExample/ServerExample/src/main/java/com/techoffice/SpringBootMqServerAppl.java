package com.techoffice;

import javax.jms.Queue;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringBootMqServerAppl {
	
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("sample.queue");
	}

	@Bean
	public BrokerService broker() throws Exception {
	    final BrokerService broker = new BrokerService();
	    broker.addConnector("tcp://localhost:61616");
	    broker.addConnector("vm://localhost");
	    broker.setPersistent(false);
	    return broker;
	}

	
	public static void main(String[] args){
        SpringApplication.run(SpringBootMqServerAppl.class, args);
	}
}
