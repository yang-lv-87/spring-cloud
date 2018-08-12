package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
	@Bean
	public JedisPoolConfig poolConfig() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(300);
		config.setMaxTotal(600);
		config.setMaxWaitMillis(1000);
		config.setTestOnBorrow(true);
		return config;
	}
	
	@Bean
	public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig poolConfig) {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setHostName("127.0.0.1");
		factory.setPort(6379);
		factory.setPoolConfig(poolConfig);;
		return factory;
	}
	
	@Bean
	public RedisTemplate redisTemplate(JedisConnectionFactory factory) {
		RedisTemplate redisTemplate = new RedisTemplate();
		redisTemplate.setConnectionFactory(factory);
		return redisTemplate;
	}
}
