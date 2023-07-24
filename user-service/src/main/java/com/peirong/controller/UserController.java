package com.peirong.controller;

import com.peirong.entity.User;
import com.peirong.mapper.UserMapper;
import com.peirong.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    @Resource
    private StringEncryptor stringEncryptor;

    private HttpServletResponse response;

    @GetMapping("/list")
    List<User> listAll() {
        return userMapper.list();
    }

    @GetMapping("/list/{id}")
    User listById(@PathVariable("id") String id) {
        //return userMapper.selectById(id);
        return userService.getUserById(id);
    }

    @GetMapping("/getAvatar/{id}")
    public void getAvatar(@PathVariable String id) throws FileNotFoundException {
        String path = userMapper.findAvatarById(id);
        System.out.println(path);
        File file = new File(path);
        try (FileInputStream inputStream = new FileInputStream(file)) {
            byte[] bytes = new byte[256 * 1024];
            int readCount = 0;
            while ((readCount = inputStream.read(bytes)) != -1) {
                response.getOutputStream().write(bytes, 0, readCount);
            }
            response.getOutputStream().flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    @GetMapping("/encode")
//    public void test() {
//        String username = stringEncryptor.encrypt("Peirong");
//        String password = stringEncryptor.encrypt("Re4030dd.");
//        String url = stringEncryptor.encrypt("jdbc:mysql://1.15.89.164:3300/EasyDrive");
//        log.info("username: {}", username);
//        log.info("password: {}", password);
//        log.info("url: {}", url);
//    }
}
