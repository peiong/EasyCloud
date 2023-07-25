package com.peirong.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peirong.entity.User;
import com.peirong.mapper.UserMapper;
import com.peirong.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
