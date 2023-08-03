package com.peirong.service.Impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.peirong.entity.User;
import com.peirong.mapper.UserMapper;
import com.peirong.service.UserService;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.ibatis.annotations.Result;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private static final String USER_NAME_PREFIX = "user_";
    private User createUserwithPhone(String phone) {
        User user = new User();
        user.setPhone(phone);
        user.setUsername(USER_NAME_PREFIX + RandomUtils.nextInt(10));
        //user.setPassword();
        save(user);
        return user;
    }

}
