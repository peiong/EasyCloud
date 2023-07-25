package com.peirong.controller;

import com.peirong.entity.User;
import com.peirong.mapper.UserMapper;
import com.peirong.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;

    @GetMapping("/list")
    List<User> listAll() {
        return userMapper.selectList(null);
    }

    @GetMapping("/list/{uid}")
    User listUser(@PathVariable String uid) {
        return userService.getUserByUid(uid);
    }
}
