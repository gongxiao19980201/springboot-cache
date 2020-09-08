package com.springboot.springbootcache;

import com.springboot.springbootcache.dao.PaymentMapper;
import com.springboot.springbootcache.entity.Payment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringbootCacheApplicationTests {
    @Autowired
    PaymentMapper paymentMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate01;

    @Test
    void contextLoads() {
        Payment payment = paymentMapper.getPayment(1);
        System.out.println(payment.getSerial());
    }
    @Test
    public void redisTest(){
        //stringRedisTemplate.opsForValue().append("k2","v2");
        Payment payment = new Payment();
        payment.setId(0);
        payment.setSerial("144541215");
        redisTemplate01.opsForValue().set(payment.getId(),payment);
        System.out.print("创建分支");
        System.out.println("主干添加");
        System.out.println("分支添加");
        System.out.println("再次更新");
        System.out.println("在线更新更改01");
        System.out.println("在线更新更改02-----------");
    }


}
