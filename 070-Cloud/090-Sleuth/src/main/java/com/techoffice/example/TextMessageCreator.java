package com.techoffice.example;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.Serializable;

public class TextMessageCreator implements MessageCreator, Serializable {
    private static final long serialVersionUID = -1L;
    private String body;

    public TextMessageCreator(String body){
        this.body = body;
    }

    @Override
    public Message createMessage(Session session) throws JMSException {
        Message message = session.createTextMessage(body);
        return message;
    }
}
