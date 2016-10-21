package com.jht.mq.activemq.example1;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * message receiver
 *
 */
@Component
public class Example1MessageReceiver {
    @JmsListener(destination = "DLQ")
    public void processMessage(String content) {
        System.out.println(content);
    }
}
