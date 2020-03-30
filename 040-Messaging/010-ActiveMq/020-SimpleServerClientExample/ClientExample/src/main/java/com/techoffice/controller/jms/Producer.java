package com.techoffice.controller.jms;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer{

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue queue;

	public void send(String msg) {
		this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
	}
	

	
}
