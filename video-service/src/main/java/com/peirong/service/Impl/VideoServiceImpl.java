package com.peirong.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peirong.entity.File;
import com.peirong.entity.User;
import com.peirong.mapper.FileMapper;
import com.peirong.service.VideoService;
import com.peirong.service.client.UserClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VideoServiceImpl extends ServiceImpl<FileMapper, File> implements VideoService {
    @Resource
    private UserClient userClient;
    public User getUserByUid(String uid) {
        return userClient.getUserById(uid);
    }
}
