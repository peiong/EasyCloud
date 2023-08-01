package com.peirong.mapper;

import com.mybatisflex.core.BaseMapper;
import com.peirong.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM user where id = #{id}")
    User getUserByUid(String id);
}
