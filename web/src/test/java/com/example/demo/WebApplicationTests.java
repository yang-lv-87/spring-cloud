package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.rubyeye.xmemcached.MemcachedClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTests {
	@Autowired
    private MemcachedClient memcachedClient;
    
	@Test
	public void contextLoads() {
	}
	
	@Test
    public void test() {
        try {
            // 设置/获取  
            memcachedClient.set("zlex", 36000, "set/get");
            // 替换  
            memcachedClient.replace("zlex", 36000, "replace");
            // 移除  
            memcachedClient.delete("zlex");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
