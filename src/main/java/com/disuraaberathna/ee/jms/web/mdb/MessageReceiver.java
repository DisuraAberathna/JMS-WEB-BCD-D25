package com.disuraaberathna.ee.jms.web.mdb;

import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

@MessageDriven(activationConfig = {})
public class MessageReceiver implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Received message: " + message.getBody(String.class));
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
