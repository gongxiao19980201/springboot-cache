package com.springboot.springbootcache.service.Service.impl;

import com.springboot.springbootcache.dao.PaymentMapper;
import com.springboot.springbootcache.entity.Payment;
import com.springboot.springbootcache.service.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@CacheConfig(cacheNames = "payment",cacheManager = "paymentCacheManager")
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentMapper paymentMapper;
    /**
     * @Cacheable:存放缓存数据
     * 参数：
     *      cacheNames/value:指定缓存组件的名字
     *      key：缓存数据使用的key，默认是方法的参数值
     *      keyGenerator：key的生成器，可以指定key的生成器组件id
     *      cacheManager/cacheResolver：缓存管理器/缓存解析器  二选一
     *      condition：指定符合条件的才缓存
     *      unless：当unless指定的条件为true，就不缓存。可以获取结果进行判断
     *      sync：是否使用异步模式，默认为false
     */
    @Cacheable(cacheNames = "payment",key = "#id")
    @Override
    public Payment getPayment(Integer id) {
        System.out.println("数据库查询");
        return paymentMapper.getPayment(id);
    }

    /**
     *
     * @CachePut:更新缓存数据
     * 参数：
     *      cacheNames/value:指定缓存组件的名字
     *      key：缓存数据使用的key，默认是方法的参数值
     *      keyGenerator：key的生成器，可以指定key的生成器组件id
     *      cacheManager/cacheResolver：缓存管理器/缓存解析器  二选一
     *      condition：指定符合条件的才缓存
     *      unless：当unless指定的条件为true，就不缓存。可以获取结果进行判断
     */
    @CachePut(value = "payment",key = "#payment.id")
    @Override
    public Payment updatePayment(Payment payment) {
        int i  = paymentMapper.updatePayment(payment);
        return payment;
    }
    @CacheEvict(value = "payment",key = "#id")
    @Override
    public Payment deletePayment(Integer id) {
        //paymentMapper.deletePayment(id);
        System.out.println("删除数据");
        return null;
    }
}
