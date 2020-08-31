package com.techoffice.example;

import brave.Span;
import brave.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.JmsMessageHeaderAccessor;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.Map;


@Slf4j
@Service
public class MessagingService {

    @Autowired
    private Tracer tracer;

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "sample.queue")
    public void receiveQueue(MessageHeaders messageHeaders,
                             @Headers Map<String, Object> headers,
                             Message message,
                             JmsMessageHeaderAccessor jmsMessageHeaderAccessor) throws JMSException {
        log.info("message from mq listener: {}", message);
        log.info("message headers from mq listener; {}", messageHeaders);
        log.info("key set: {}", messageHeaders.keySet());
    }

    public void send(String text){
        Span span = tracer.nextSpan().name("Testing");
        log.info("trace id: {}" , span.context().traceIdString());
        MessageCreator messageCreator = new TextMessageCreator(text);
        jmsTemplate.send("sample.queue", messageCreator);

    }


}
