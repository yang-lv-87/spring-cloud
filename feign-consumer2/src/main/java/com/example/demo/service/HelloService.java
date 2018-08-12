package com.example.demo.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface HelloService {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	String hello(@RequestParam("name") String name);
}
