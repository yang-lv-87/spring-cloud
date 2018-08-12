package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
	@Value("${spring.redis.maxIdle}")
	private int maxIdle;
	
	@Value("${spring.redis.maxTotal}")
	private int maxTotal;
	
	@Value("${spring.redis.testOnBorrow}")
	private boolean testOnBorrow;
	
	@Value("${spring.redis.hostName}")
	private String hostName;
	
	@Value("${spring.redis.port}")
	private int port;
	
	@Bean
	public JedisPoolConfig poolConfig() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(maxIdle);
		config.setMaxTotal(maxTotal);
		return config;
	}
	
	@Bean
	public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig poolConfig) {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setHostName(hostName);
		factory.setPort(port);
		factory.setPoolConfig(poolConfig);
		return factory;
	}
	
	@Bean
	public RedisTemplate redisTemplate(JedisConnectionFactory factory) {
		RedisTemplate redisTemplate = new RedisTemplate();
		redisTemplate.setConnectionFactory(factory);
		return redisTemplate;
	}

}


/*
@Component
@ConfigurationProperties(prefix="spring.redis")
public class RedisConfig {
	private int maxIdle;
	
	private int maxTotal;
	
	private long maxWaitMillis;
	
	private boolean testOnBorrow;
	
	private String hostName;
	
	private int port;
	
	@Bean
	public JedisPoolConfig genPoolConfig() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(maxIdle);
		config.setMaxTotal(maxTotal);
		config.setMaxWaitMillis(maxWaitMillis);
		config.setTestOnBorrow(testOnBorrow);
		return config;
	}
	
	@Bean
	public JedisConnectionFactory genJedisConnectionFactory(JedisPoolConfig poolConfig) {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setHostName(hostName);
		factory.setPort(port);
		factory.setPoolConfig(poolConfig);
		return factory;
	}
	
	@Bean
	public RedisTemplate genRedisTemplate(JedisConnectionFactory factory) {
		RedisTemplate redisTemplate = new RedisTemplate();
		redisTemplate.setConnectionFactory(factory);
		return redisTemplate;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public long getMaxWaitMillis() {
		return maxWaitMillis;
	}

	public void setMaxWaitMillis(long maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
*/
