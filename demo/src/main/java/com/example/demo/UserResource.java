package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/user")
public class UserResource {
    private DemoConfig config;

    @Autowired
    public UserResource(DemoConfig config) {
        this.config = config;
    }

    @GET
    public String getUserInfo(){
        return "my custom user info property: "+config.getProperty1();
    }
}
