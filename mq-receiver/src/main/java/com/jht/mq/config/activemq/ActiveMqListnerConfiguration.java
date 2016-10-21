package com.jht.mq.config.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/** ActiveMq默认监听
 * Created by ${huipei.x} on 2016/8/31.
 */
@Configuration
@EnableJms
public class ActiveMqListnerConfiguration {

	@Autowired
	ConnectionFactory connectionFactory;
	
	@Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrency("5-10");
        return factory;
    }

}
