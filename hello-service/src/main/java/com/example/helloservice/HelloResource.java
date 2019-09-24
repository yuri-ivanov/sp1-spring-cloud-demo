package com.example.helloservice;


import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloResource {
    private HelloServiceConfig config;

    @Autowired
    public HelloResource(HelloServiceConfig config) {
        this.config = config;
    }

    @GET
    public String getInfo(){
        return "hello-service property: "+config.getProperty1();
    }
}
