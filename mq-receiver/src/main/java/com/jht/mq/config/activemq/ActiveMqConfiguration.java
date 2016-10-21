
package com.jht.mq.config.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;
import java.util.Arrays;

/** ActiveMq消息队列基础配置
 * Created by ${huipei.x} on 2016/8/31.
 */
@Configuration
@EnableConfigurationProperties(ActiveMqProperties.class)
public class ActiveMqConfiguration {

	@Autowired
	ActiveMqProperties activeMqProperties;

	@Bean
	public ActiveMQConnectionFactory connectionFactory(){
		ActiveMQConnectionFactory connectionFactory=new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(activeMqProperties.getBrokerURL());
		connectionFactory.setTrustedPackages(Arrays.asList("com.spiss"));
		connectionFactory.setMaxThreadPoolSize(activeMqProperties.getMaxThreadPoolSize());
		connectionFactory.setUseAsyncSend(activeMqProperties.getUseAsyncSend());
		connectionFactory.setTrustAllPackages(true);
		return connectionFactory;
	}


	@Bean
	public Queue queue(){
		ActiveMQQueue activeMQ = new ActiveMQQueue(activeMqProperties.getQueueName());
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

