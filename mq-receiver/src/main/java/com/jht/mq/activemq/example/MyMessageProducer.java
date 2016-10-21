/*
package com.jht.mq.activemq.example;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;



@Component
public class MyMessageProducer {
	@Autowired
	private Queue queue;
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void sendMessage(MessageInfo message){
		String json = JSON.toJSONString(message);
		jmsTemplate.convertAndSend(queue, json);
    }

}
*/
