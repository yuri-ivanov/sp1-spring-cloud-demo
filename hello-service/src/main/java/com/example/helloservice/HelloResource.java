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
    public String getUserInfo(){
        return "my custom user info property: "+config.getProperty1();
    }
}
