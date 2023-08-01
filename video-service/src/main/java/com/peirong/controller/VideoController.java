package com.peirong.controller;

import com.peirong.entity.User;
import com.peirong.service.Impl.VideoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Controller
@RestController
@RequestMapping("/file")
public class VideoController {

    @Resource
    private VideoServiceImpl videoService;

    @GetMapping("/list/{uid}")
    User listUser(@PathVariable String uid) {
        System.out.println(videoService.getUserByUid(uid));
        return videoService.getUserByUid(uid);
    }
}
