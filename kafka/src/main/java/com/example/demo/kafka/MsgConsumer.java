package com.example.demo.kafka;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 */
@Component
@KafkaListener(topics = { "test"})
public class MsgConsumer {
	
	@KafkaHandler
	public void process(String hello) {
		System.out.println("Receiver: " + hello);
	}

}