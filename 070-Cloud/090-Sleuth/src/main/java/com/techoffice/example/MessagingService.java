package com.techoffice.example;

import brave.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.Enumeration;

@Slf4j
@Service
public class MessagingService {

    @Autowired
    private Tracer tracer;

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "sample.queue")
    public void receiveQueue(MessageHeaders messageHeaders, Message message) throws JMSException {
        log.info("message from mq listener: {}", message);
        log.info("message headers from mq listener; {}", messageHeaders);
    }

    public void send(String message){
        jmsTemplate.convertAndSend("sample.queue", message);
    }


}
