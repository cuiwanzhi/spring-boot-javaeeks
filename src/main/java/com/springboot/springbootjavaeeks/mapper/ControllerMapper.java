package com.springboot.springbootjavaeeks.mapper;

import com.springboot.springbootjavaeeks.bean.Controller;
import com.springboot.springbootjavaeeks.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

/**
 * @author cuiwanzhi
 * @date 2020/7/5 22:11
 */
@Mapper
public interface ControllerMapper {
    @Select("select * from controller where id=#{id}")
    public Controller getController(int id);

    @Update("update  User set password ='000000' where id=#{id}")
    public int updateUserPassword(int id);

    @Select("select * from user ")
    public List<User> getAllUser();

    @Delete("delete from user where id=#{id}")
    public int deleteUser(int id);

    @Update("update user set user_name=#{user_name} , password=#{password} ,name=#{name} , gender=#{gender},birthday=#{dirthday} ,contact=#{contact} , e_mail=#{e_mail} where id= #{id}")
    public int updateUser(int id ,String user_name, String password , String name , String gender , Date birthday,String contact ,String e_mail);
}
