package com.example.demo.fallback;

import org.springframework.stereotype.Component;

import com.example.demo.service.HelloService;

@Component
public class HelloServiceFallback implements HelloService {

	@Override
	public String hello() {
		return "hello error";
	}

}
