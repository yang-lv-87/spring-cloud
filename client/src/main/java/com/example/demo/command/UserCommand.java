package com.example.demo.command;

import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class UserCommand extends HystrixCommand<User> {

	private RestTemplate restTemplate;
	
	private Long id;

	public UserCommand(RestTemplate restTemplate, Long id) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("UserGroup")));
		this.restTemplate = restTemplate;
		this.id = id;
	}

	@Override
	protected User run() throws Exception {
		System.out.println("UserCommand 1");
//		User user = restTemplate.getForObject("http://HELLO-SERVICE/users", User.class);
		System.out.println("UserCommand 1 -");
		return new User();
	}

//	@Override
//	protected String getCacheKey() {
//		return String.valueOf(id);
//	}

}
