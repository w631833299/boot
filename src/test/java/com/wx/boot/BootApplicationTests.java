package com.wx.boot;

import com.wx.boot.redis.RedisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootApplication.class)
@WebAppConfiguration
public class BootApplicationTests {

	@Autowired
	private RedisConfig redisConfig;

	@Test
	public void contextLoads() {
		System.err.println("redis返回值:"+redisConfig.test());
	}

}
