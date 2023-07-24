package com.peirong.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peirong.entity.File;
import com.peirong.mapper.FileMapper;
import com.peirong.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {

    @Resource
    private RestTemplate template;
    @Resource
    private FileMapper fileMapper;
//    public File getFileByUid(String id) {
//        return template.getForObject("http://userservice/user/list/" + id, File.class);
//    }
}
