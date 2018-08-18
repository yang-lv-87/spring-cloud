package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamApplicationTests2 {
	
	@Autowired
	private MessageChannel input;
	
	@Autowired
	@Qualifier("input2")
	private MessageChannel input2;
	
	@Test
	public void contextLoads() {
		input.send(MessageBuilder.withPayload("**************From SinkSender").build());
		input2.send(MessageBuilder.withPayload("#################From SinkSender").build());
	}
	
	@Test
	public void hello() {
	}

}
