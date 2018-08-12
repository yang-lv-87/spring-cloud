package com.nosql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TestRedis {

	@Test
	public void test1() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(5);
		config.setTestOnBorrow(false);
		JedisPool jedisPool = new JedisPool(config, "192.168.1.111", 6379);
		Jedis jedis = jedisPool.getResource();
		jedis.set("key2", "value2");
		jedis.close();
		jedisPool.close();
	}
	
	@Test
	public void test2() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(5);
		config.setTestOnBorrow(false);
		JedisPool jedisPool = new JedisPool(config, "192.168.1.111", 6379);
		Jedis jedis = jedisPool.getResource();
		jedis.sadd("skey1", "mysql", "oracle");
		Set<String> set = jedis.smembers("skey1");
		for (String each: set) {
			System.out.println(each);
		}
		jedis.close();
		jedisPool.close();
	}
	
	@Test
	public void test3() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(5);
		config.setTestOnBorrow(false);
		JedisPool jedisPool = new JedisPool(config, "192.168.1.111", 6379);
		Jedis jedis = jedisPool.getResource();
		jedis.lpush("lkey1", "v1", "v2", "v3");
		List<String> list = jedis.lrange("lkey1", 0, 10);
		for (String each: list) {
			System.out.println(each);
		}
		jedis.close();
		jedisPool.close();
	}
	
	@Test
	public void test4() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(5);
		config.setTestOnBorrow(false);
		JedisPool jedisPool = new JedisPool(config, "192.168.1.111", 6379);
		Jedis jedis = jedisPool.getResource();
		Map<String, String> hashmap = new HashMap<String, String>();
		hashmap.put("name1", "value1");
		hashmap.put("name2", "value2");
		jedis.hmset("hmkey1", hashmap);
		List<String> list = jedis.hmget("hmkey1", "name1", "name2");
		for (String each: list) {
			System.out.println(each);
		}
		jedis.close();
		jedisPool.close();
	}
	
	@Test
	public void test5() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(5);
		config.setTestOnBorrow(false);
		JedisPool jedisPool = new JedisPool(config, "192.168.1.111", 6379);
		Jedis jedis = jedisPool.getResource();
		Map<String, Double> hashmap = new HashMap<String, Double>();
		hashmap.put("name1", 2.1);
		hashmap.put("name2", 3.1);
		jedis.zadd("zkey1", hashmap);
		Set<String> set = jedis.zrange("zkey1", 0, 10);
		for (String each: set) {
			System.out.println(each);
		}
		jedis.close();
		jedisPool.close();
	}
}
