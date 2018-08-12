package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.HelloService;

@RestController
public class ConsumerController {

	@Autowired
	private HelloService helloService;

	@RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
	public String hello() {
		return helloService.helloService();
	}

}
