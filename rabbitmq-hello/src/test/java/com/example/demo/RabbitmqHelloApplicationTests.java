package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.rabbitmq.Sender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqHelloApplicationTests {
	
	@Autowired
	private Sender sender;

	@Test
	public void contextLoads() {
		
	}
	
	@Test
	public void hello() {
		sender.send();
	}

}
