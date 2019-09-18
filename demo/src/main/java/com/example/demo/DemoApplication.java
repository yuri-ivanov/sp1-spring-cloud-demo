package com.example.demo;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(DemoConfig.class)
public class DemoApplication implements ApplicationRunner {
	private DemoConfig config;

	public DemoApplication(DemoConfig config) {
		this.config = config;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public ResourceConfig getJerseyConfig(){
		return new ResourceConfig().register(UserResource.class);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(config.property1);
	}
}
