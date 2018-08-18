package com.example.demo.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

public interface SinkSender {
	@Output(Sink.INPUT) // input通道输出
	MessageChannel output();

	@Output("input2") // input2通道输出,测试直接注解 @HelloApplicationTest2
	MessageChannel output2();
}
