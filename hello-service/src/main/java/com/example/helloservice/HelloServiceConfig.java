package com.example.helloservice;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class HelloServiceConfig {
    String property1;

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

}
