package com.jht.mq.config.activemq.activemq;/*
package com.jht.mq.config.activemq;

import com.jht.mq.sender.activemq.MessageReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.listener.SimpleMessageListenerContainer;

import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class MessagingListnerConfiguration {

	@Autowired
	ConnectionFactory connectionFactory;
    @Autowired
    MessageReceiver messageReceiver;
	@Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrency("5-10");
        return factory;
    }

  */
/*  @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
        SimpleMessageListenerContainer factory = new SimpleMessageListenerContainer();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageListener(messageReceiver);
        factory.setDestinationName("order-queue");
        factory.setConcurrentConsumers(8);
        return factory;
    }*//*


}
*/
