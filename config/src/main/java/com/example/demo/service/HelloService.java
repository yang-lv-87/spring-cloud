package com.example.demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.fallback.HelloServiceFallback;

@FeignClient(value = "hello-service", fallback = HelloServiceFallback.class)
public interface HelloService {
	
	@RequestMapping("/hello")
	String hello();
}
