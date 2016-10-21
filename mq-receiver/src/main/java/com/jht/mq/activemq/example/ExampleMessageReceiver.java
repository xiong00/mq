package com.jht.mq.activemq.example;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jht.mq.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Queue;


@Component
public class ExampleMessageReceiver {

	/*@Autowired
	private Queue queue;*/

	public void receiveMessage(final Message<MessageInfo> message) throws JMSException {
		/*MessageHeaders headers =  message.getHeaders();
		System.out.println("Application : headers received : {}" + headers);*/
		String s=message.getPayload().toString();
		MessageInfo messageInfo =JSON.parseObject(s,MessageInfo.class) ;
		System.out.println("111" + messageInfo);
	}


}
