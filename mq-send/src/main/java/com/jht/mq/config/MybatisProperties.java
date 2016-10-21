package com.jht.mq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by ${huipei.x} on 2016/9/2.
 */
@ConfigurationProperties(prefix = "connection",locations ="classpath:datasource.properties")
public class MybatisProperties {

    private String url;
    private String username;
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
