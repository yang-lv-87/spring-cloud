package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RefactorHelloService;

@RestController
public class ConsumerController {
	
	@Autowired
	private RefactorHelloService refactorHelloService;
	
	@RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
	public String helloConsumer() {
		return refactorHelloService.hello("yang");
	}
}
