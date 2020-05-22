package com.yipinketang.redis;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * description: AppRedisTest <br>
 * date: 2019/12/18 20:55 <br>
 * author: jiuson <br>
 * version: 1.0 <br>
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppRedis.class)
public class AppRedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void getRedisValueByKey(){
        String value = stringRedisTemplate.opsForValue().get("name");
        System.out.println(value);
    }
}