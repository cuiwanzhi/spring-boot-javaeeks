package com.springboot.springbootjavaeeks.mapper;

import com.springboot.springbootjavaeeks.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

/**
 * @author cuiwanzhi
 * @date 2020/7/4 16:21
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    public User getUser(int id);

    @Update("update user set user_name =#{user_name}, name=#{name}, gender=#{gender}, birthday=#{birthday}, contact=#{contact}, e_mail=#{e_mail} where id =#{id}")
    public int updateMessage(int id,String user_name, String name, String gender, Date birthday, String contact, String e_mail);

    @Update("update  user set password =#{newPassword} where id = #{id}")
    public void updataPassword(String newPassword, int id);

    @Select("select sum(income_number) from income where id=#{id} group by id;")
    public float getIncome(int id);

    @Select("select sum(Year_number) from Year where id=#{id} group by id;")
    public float getYear(int id);
}
