package com.jht.mq.receiver.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Created by ${huipei.x} on 2016/8/29.
 */
@Component
public class RabbitMessageReceiver {

    private CountDownLatch countDownLatch = new CountDownLatch(1);

   @RabbitListener(queues = "jht-que")
    public void receiveMsg(String message) {
        System.out.println("Message Received: " + message);
        countDownLatch.countDown();
    }
    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }
}
