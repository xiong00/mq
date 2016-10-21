package com.jht.mq.config.activemq;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by ${huipei.x} on 2016/9/2.
 */

@ConfigurationProperties(prefix = "activeMQ")
public class ActiveMqProperties {

    private String brokerURL;
    private String userName;
    private String password;
    private int maxThreadPoolSize;
    private Boolean useAsyncSend;
    private String queueName;


    public String getBrokerURL() {
        return brokerURL;
    }

    public void setBrokerURL(String brokerURL) {
        this.brokerURL = brokerURL;
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

    public int getMaxThreadPoolSize() {
        return maxThreadPoolSize;
    }

    public void setMaxThreadPoolSize(int maxThreadPoolSize) {
        this.maxThreadPoolSize = maxThreadPoolSize;
    }

    public Boolean getUseAsyncSend() {
        return useAsyncSend;
    }

    public void setUseAsyncSend(Boolean useAsyncSend) {
        this.useAsyncSend = useAsyncSend;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }
}
