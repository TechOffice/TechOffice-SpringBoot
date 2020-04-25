package com.techoffice.messaging;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	@JmsListener(destination = "sample.queue", containerFactory="jmsListenerContainerFactory")
	public void receiveQueue(String text) {
		System.out.println(text);
	}
	
}
