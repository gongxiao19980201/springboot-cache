package com.springboot.springbootcache.dao;

import com.springboot.springbootcache.entity.Payment;
import com.springboot.springbootcache.entity.User;

public interface UserMapper {
    User getUser(Integer id);
}
