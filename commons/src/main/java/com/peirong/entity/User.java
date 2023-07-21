package com.peirong.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

@Data
@TableName("user")
public class User {

    private Long id;
    private String username;
    private String phone;
    private String email;

    // 不查询该字段
    @TableField(select = false)
    private String password;

    @TableField(select = false)
    private String avatar;
    @TableField(value = "created_at")
    private Date createdAt;
    @TableField(value = "update_time")
    private Date updateTime;
}
