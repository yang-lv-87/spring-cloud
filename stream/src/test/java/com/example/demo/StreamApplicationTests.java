package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.stream.SinkSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamApplicationTests {
	
	@Autowired
	private SinkSender sinkSender;
	
	@Test
	public void contextLoads() {
		sinkSender.output().send(MessageBuilder.withPayload("from output").build());
		sinkSender.output2().send(MessageBuilder.withPayload("from output2").build());
	}
	
	@Test
	public void hello() {
	}

}
