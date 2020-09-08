package com.springboot.springbootcache.service.Service;

import com.springboot.springbootcache.dao.UserMapper;
import com.springboot.springbootcache.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Cacheable(cacheNames = "user",cacheManager = "userCacheManger")
    public User getUser(Integer id){
        return userMapper.getUser(id);
    }
}
