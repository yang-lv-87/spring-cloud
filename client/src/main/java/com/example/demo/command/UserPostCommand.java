package com.example.demo.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class UserPostCommand extends HystrixCommand<User> {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private User user;

	public UserPostCommand(RestTemplate restTemplate, User user) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GetSetGet")));
		this.restTemplate = restTemplate;
		this.user = user;
	}

	@Override
	protected User run() throws Exception {
		User u = restTemplate.postForObject("http://HELLO-SERVICE/users", user, User.class);
		UserGetCommand.flushCache(user.getId());
		return u;
	}
}
