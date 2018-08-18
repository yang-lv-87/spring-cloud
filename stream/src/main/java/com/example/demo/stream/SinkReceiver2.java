package com.example.demo.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(value = {Sink.class, SinkSender.class})
public class SinkReceiver2 {
	
	private static Logger logger = LoggerFactory.getLogger(SinkReceiver2.class);
	
	@StreamListener(Sink.INPUT)
	public void receive(Object payload) {
		logger.info("Received: " + payload);
	}
	
	@StreamListener("input2")
	public void receive2(Object payload) {
		logger.info("Received2: " + payload);
	}
}
