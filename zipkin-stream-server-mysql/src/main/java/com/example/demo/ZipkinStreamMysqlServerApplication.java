package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

@EnableZipkinStreamServer
@SpringBootApplication
public class ZipkinStreamMysqlServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinStreamMysqlServerApplication.class, args);
	}
}
