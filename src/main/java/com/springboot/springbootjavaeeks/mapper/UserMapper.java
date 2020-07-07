package com.springboot.springbootjavaeeks.mapper;

import com.springboot.springbootjavaeeks.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author cuiwanzhi
 * @date 2020/7/7 12:41
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    public User selectUser(int id);
}
