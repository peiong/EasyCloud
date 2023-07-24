package com.peirong.controller;

import com.peirong.entity.File;
import com.peirong.mapper.FileMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    private FileMapper fileMapper;

    @GetMapping("/list")
    List<File> listAll() {
        System.out.println(fileMapper.list());
        return fileMapper.list();
    }
}
