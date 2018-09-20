package com.wx.boot.redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * @Description: redis工具类
 * @Date: 2018/9/20
 * @Auther: wangxiang
 */
@Component
public class RedisConfig{

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test(){
        ValueOperations<String,String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set("mykey4","random1="+Math.random());
        System.out.println(valueOperations.get("mykey4"));
    }
}
