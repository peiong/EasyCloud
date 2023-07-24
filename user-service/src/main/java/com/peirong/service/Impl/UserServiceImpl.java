package com.peirong.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peirong.entity.User;
import com.peirong.mapper.UserMapper;
import com.peirong.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserById(String id) {
        return restTemplate.getForObject("http://userservice/user/list" + id, User.class);
    }
}
