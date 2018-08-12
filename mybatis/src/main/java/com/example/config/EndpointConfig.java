package com.example.config;

import java.util.Map;

import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.endpoint.PersonEndpoint;

@Configuration
public class EndpointConfig {

	@Bean
	public static Endpoint<Map<String, Object>> servertime() {
		return new PersonEndpoint();
	}
}
