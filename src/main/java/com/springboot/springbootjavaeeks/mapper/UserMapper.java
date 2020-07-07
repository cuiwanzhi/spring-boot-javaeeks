package com.springboot.springbootjavaeeks.mapper;

import com.springboot.springbootjavaeeks.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author cuiwanzhi
 * @date 2020/7/7 12:41
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    public User selectUser(int id);

    @Select("select * from user ")
    public List<User> getAllUser();

    @Transactional
    @Insert("insert into user( name,password) VALUE(#{name},'000000')")
    public int insertUser(String name);

    @Delete("delete from user where id = #{id}")
    public int deleteUser(int id);

    @Update("update user set password ='000000' where id = #{id}")
    public int restorePassword(int id);
}
