package com.peirong.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("file")
public class File {
    private Long id;
    private Long uid;
    private String filename;
    private String filepath;
    private String filesize;
    @TableField(value = "upload_time")
    private String uploadTime;
    @TableField(value = "update_time")
    private String updateTime;
}
