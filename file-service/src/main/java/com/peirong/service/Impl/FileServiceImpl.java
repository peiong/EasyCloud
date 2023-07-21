package com.peirong.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peirong.entity.File;
import com.peirong.mapper.FileMapper;
import com.peirong.service.FileService;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {
}
