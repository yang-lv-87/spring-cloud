package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.command.CommandHelloWorld;
import com.example.demo.command.UserCommand;
import com.example.demo.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "helloFallback")
	public String helloService() {
		int n = 1/0;
		return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
	}
	
	public String helloFallback() {
		return "error";
	}
}
