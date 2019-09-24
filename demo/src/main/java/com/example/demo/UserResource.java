package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/user")
public class UserResource {
    private DemoConfig config;
    private RestTemplate restTemplate;

    @Autowired
    public UserResource(DemoConfig config, RestTemplate restTemplate) {
        this.config = config;
        this.restTemplate = restTemplate;
    }

    @GET
    public String getUserInfo(){
        String helloServiceMessage = restTemplate.getForObject("http://hello-service/hello", String.class);
        return "my custom user info property: "+config.getProperty1()+" "+helloServiceMessage;
    }
}
