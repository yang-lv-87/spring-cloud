package com.nosql;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.junit.Test;

import net.spy.memcached.MemcachedClient;

public class TestMemcached {

	@Test
	public void test1() throws IOException {
		InetSocketAddress ia = new InetSocketAddress("192.168.1.111", 11211);
		MemcachedClient client = new MemcachedClient(ia);
		client.set("key1", 900, "value2");
		client.shutdown();
	}
	
	@Test
	public void test2() throws IOException {
		InetSocketAddress ia = new InetSocketAddress("192.168.1.111", 11211);
		MemcachedClient client = new MemcachedClient(ia);
		User user = new User();
		user.setAge(21);
		user.setName("name1");
		client.set("key2", 0, user);
		User user2 = (User)client.get("key2");
		System.out.println(user2);
		client.shutdown();
	}
}
