package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SleuthApplication {
	
	private static Logger logger = LoggerFactory.getLogger(SleuthApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SleuthApplication.class, args);
	}
}
