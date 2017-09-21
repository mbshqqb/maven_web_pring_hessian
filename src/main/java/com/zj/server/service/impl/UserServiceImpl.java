package com.zj.server.service.impl;


import com.zj.bean.User;
import com.zj.server.service.UserService;

public class UserServiceImpl implements UserService {
    public User getUserbyName(String name) {
        User u = new User();
        u.setName(name);
        u.setEmail("abc@abc.com");
        u.setAge(20);
        return u;
    }
}
