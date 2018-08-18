package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.activemq.Producer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivemqApplicationTests {
	
	@Autowired
	private Producer producer;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSend() {
		producer.send("yang");
	}
}
