package com.disuraaberathna.ee.jms.web.mdb;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

@MessageDriven(activationConfig = {
//        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/MyTopic")
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/MyQueue"),
//        @ActivationConfigProperty(propertyName = "maxSession", propertyValue = "1")  // Server-specific
        @ActivationConfigProperty(propertyName = "maxPoolSize", propertyValue = "1")
})
public class MessageReceiver implements MessageListener {

    @PostConstruct
    public void init() {
        System.out.println("MessageReceiver init...");
    }

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println(this + "Received message: " + message.getBody(String.class));
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
