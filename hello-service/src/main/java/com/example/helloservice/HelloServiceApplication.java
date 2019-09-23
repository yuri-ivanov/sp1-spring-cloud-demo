package com.example.helloservice;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(HelloServiceConfig.class)
public class HelloServiceApplication implements ApplicationRunner {
	private HelloServiceConfig config;

	public HelloServiceApplication(HelloServiceConfig config) {
		this.config = config;
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloServiceApplication.class, args);
	}

	@Bean
	public ResourceConfig getJerseyConfig(){
		return new ResourceConfig().register(HelloResource.class);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(config.property1);
	}
}
