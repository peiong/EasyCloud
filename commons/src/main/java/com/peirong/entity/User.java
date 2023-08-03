package com.peirong.entity;

import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.sql.Date;

@Data
@Table("tb_user")
public class User {

    private Long id;
    private String username;
    private String phone;
    private String email;

    private String password;

    //private String avatar;
    private Date createdAt;
    private Date updateTime;
}
