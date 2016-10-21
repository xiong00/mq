package com.jht.mq.sender.activemq;


import com.jht.mq.model.Goods;
import com.jht.mq.model.Order;
import com.jht.mq.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;


@Component
public class MessageSender {

	@Autowired
	JmsTemplate jmsTemplate;


	public  void sendOrder(final Order order) {

		jmsTemplate.send(new MessageCreator(){
				public Message createMessage(Session session) throws JMSException{
					ObjectMessage objectMessage = session.createObjectMessage(order);
					System.out.println("Message"+objectMessage.getObject()  );
					return objectMessage;
					
				}
			
			});

		
	}


	public void sendUser(final User user) {

		jmsTemplate.send("uoo",new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage objectMessage = session.createObjectMessage(user);
				System.out.println("Message" + objectMessage.getObject());
				return objectMessage;

			}

		});
	}


	public void sendGoods(final Goods goods) {

		jmsTemplate.send("goo",new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage objectMessage = session.createObjectMessage(goods);
				System.out.println("Message" + objectMessage.getObject());
				return objectMessage;

			}

		});
	}
	}
