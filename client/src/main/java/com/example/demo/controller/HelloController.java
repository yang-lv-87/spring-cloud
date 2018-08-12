package com.example.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.command.UserCommand;
import com.example.demo.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HelloController {

	@Autowired
	private DiscoveryClient client;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final Logger logger = Logger.getLogger(HelloController.class);
	
	@RequestMapping(value= "/index", method = RequestMethod.GET)
	public String index() {
		ServiceInstance instance = client.getLocalServiceInstance();
		logger.info(instance.getHost() + " " + instance.getServiceId());
		logger.info("hello 1");
		
		UserCommand userCommand = new UserCommand(restTemplate, 1L);
		User user = userCommand.execute();
		
		return "hello, world";
	}
	
	@RequestMapping(value= "/users", method = RequestMethod.GET)
	public User users() {
		logger.info("users 1");
		return new User();
	}
	
	@RequestMapping(value= "/hello", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "helloFallback")
	public String helloService() {
		System.out.println("helloService");
//		int n = 1/0;
		return "helloService";
	}
	
	public String helloFallback() {
		System.out.println("helloFallback");
		return "helloFallback";
	}
}
