package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.HelloService;

@RestController("/refactor")
public class RefactorHelloController implements HelloService {

	@Override
	public String hello(@RequestParam("name") String name) {
		String result = "hello " + name;
		System.out.println(result);
		return result;
	}

}
