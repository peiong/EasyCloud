package com.peirong.controller;

import com.peirong.entity.User;
import com.peirong.mapper.UserMapper;
import com.peirong.service.Impl.CacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private UserMapper userMapper;
    @Resource
    private StringEncryptor stringEncryptor;

    private final CacheService cacheService;
//    @GetMapping("/list")
//    List<User> listAll() {
//        return userMapper.selectList(null);
//    }

    @GetMapping("/list/{uid}")
    User listUser(@PathVariable String uid) {
        return userMapper.getUserByUid(uid);
    }

    @GetMapping("/multiply/{a}/{b}")
    public int multiply(@PathVariable int a, @PathVariable int b) {
        return cacheService.mutiply(a, b);
    }
    @GetMapping("/test")
    public String test() {
        return stringEncryptor.encrypt("jdbc:mysql://1.15.89.164:3300/db_video?&characterEncoding=utf8&serverTimezone=GMT%2B8");
    }
}
