package com.example.demo.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;

public class UserGetCommand extends HystrixCommand<User> {
	
	private static final HystrixCommandKey GETTER_KEY = HystrixCommandKey.Factory.asKey("CommandKey");

	@Autowired
	private RestTemplate restTemplate;
	
	private Long id;

	public UserGetCommand(RestTemplate restTemplate, Long id) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GetSetGet")).andCommandKey(GETTER_KEY));
		this.restTemplate = restTemplate;
		this.id = id;
	}

	@Override
	protected User run() throws Exception {
		User user = restTemplate.getForObject("http://HELLO-SERVICE/users/{1}", User.class, id);
		return user;
	}
	
	@CacheResult(cacheKeyMethod = "getUserByIdCacheKey")
	@com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
	public User getUserById(Long id) {
		User user = restTemplate.getForObject("http://HELLO-SERVICE/users/{1}", User.class, id);
		return user;
	}
	
	private Long getUserByIdCacheKey(Long id) {
		return id;
	}
	
	@CacheResult
	@com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
	public User getUserById2(@CacheKey("id") Long id) {
		User user = restTemplate.getForObject("http://HELLO-SERVICE/users/{1}", User.class, id);
		return user;
	}
	
	@CacheRemove(commandKey = "getUserById2")
	@com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
	public User update(@CacheKey("id") User user) {
		User u = restTemplate.postForObject("http://HELLO-SERVICE/users", user, User.class);
		return u;
	}

	@Override
	protected String getCacheKey() {
		return String.valueOf(id);
	}
	
	public static void flushCache(Long id) {
		HystrixRequestCache.getInstance(GETTER_KEY, HystrixConcurrencyStrategyDefault.getInstance()).clear(String.valueOf(id));
	}
	
}
