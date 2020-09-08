package com.springboot.springbootcache.controller;

import com.springboot.springbootcache.entity.Payment;
import com.springboot.springbootcache.entity.User;
import com.springboot.springbootcache.service.Service.PaymentService;
import com.springboot.springbootcache.service.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    CacheManager userCacheManger;
    @RequestMapping("/user/{id}")
    @ResponseBody
    public String getPayment(@PathVariable("id")Integer id){
        User user = userService.getUser(id);
        System.out.println(user.getId());
        return user.getUsername();
    }
    @RequestMapping("/user/code/{id}")
    @ResponseBody
    public String getUser(@PathVariable("id")Integer id){
        User user = userService.getUser(id);
        Cache cache = userCacheManger.getCache("user");
        cache.put("custom",user);
        System.out.println(user.getId());
        return user.getUsername();
    }
}
