package com.jht.mq.config.rabbit;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by ${huipei.x} on 2016/9/2.
 */

@ConfigurationProperties(prefix = "RabbitMQ")
public class RabbitMqProperties {

    private String URL;
    private String userName;
    private String password;
    private int post;
    private String queueName;
    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }
}
