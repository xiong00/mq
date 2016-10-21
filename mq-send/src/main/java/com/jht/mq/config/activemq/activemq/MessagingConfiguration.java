
package com.jht.mq.config.activemq.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;
import java.util.Arrays;

@Configuration
public class MessagingConfiguration implements EnvironmentAware {

	private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
	
	private static final String ORDER_QUEUE = "order-queue";

	private RelaxedPropertyResolver propertyResolver;

	@Override
	public void setEnvironment(Environment environment) {
		this.propertyResolver = new RelaxedPropertyResolver(environment, "activeMQ.");
	}

	@Bean
	public ActiveMQConnectionFactory connectionFactory(){
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
		connectionFactory.setTrustedPackages(Arrays.asList("com.jht"));
		return connectionFactory;
	}

	@Bean
	public Queue queue(){
		ActiveMQQueue activeMQ = new ActiveMQQueue(ORDER_QUEUE);
		return activeMQ;
	}
	@Bean
	public JmsTemplate jmsTemplate(){
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		template.setDefaultDestination(queue());
		return template;
	}


}

