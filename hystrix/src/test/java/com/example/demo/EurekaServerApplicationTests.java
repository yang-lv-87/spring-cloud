package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.command.CommandHelloWorld;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaServerApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCommand1() {
		new CommandHelloWorld("World").execute();
	}
}
