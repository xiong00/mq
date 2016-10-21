package com.jht.mq.config.rabbit;


import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


/** RabbitMQ 基础配置
 * Created by ${huipei.x} on 2016/8/29.
 */

//@Configuration
//@EnableAutoConfiguration
//@EnableConfigurationProperties(RabbitMqProperties.class)
public class RabbitMQConfig {



    @Autowired
    RabbitMqProperties rabbitMqProperties;
    @Bean
    Queue queue() {
        return new Queue(rabbitMqProperties.getQueueName(), false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("jht-exchange");
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(rabbitMqProperties.getQueueName());
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(
                rabbitMqProperties.getURL());
        connectionFactory.setUsername(rabbitMqProperties.getUserName());
        connectionFactory.setPassword(rabbitMqProperties.getPassword());
        connectionFactory.setPort(AMQP.PROTOCOL.PORT);
        return connectionFactory;
    }

    @Bean
    SimpleMessageListenerContainer container() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
       container.setQueueNames(rabbitMqProperties.getQueueName());
        return container;
    }


    // 创建rabbitTemplate 消息模板类
    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setRoutingKey(rabbitMqProperties.getQueueName());
        template.setQueue(rabbitMqProperties.getQueueName());
        return template;
    }


}
