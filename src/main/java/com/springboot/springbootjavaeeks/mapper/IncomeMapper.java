package com.springboot.springbootjavaeeks.mapper;

import com.springboot.springbootjavaeeks.bean.Income;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @author cuiwanzhi
 * @date 2020/7/5 15:30
 */
@Mapper
public interface IncomeMapper {
    @Select("select * from income ")
    public List<Income> getAllIncome();

    @Select("select * from income where id=#{id}")
    public Income selectIncome(int id);

    @Select("select * from income where user_id=#{user_id}")
    public List<Income> getUserIncome(int user_id);

    @Insert("insert into income(user_id, income_type, income_number, income_date) values (#{user_id},#{income_type},#{income_number},#{income_date});")
    public int insertIncome(int user_id, String income_type, float income_number, Date income_date);

    @Update("update income set user_id=#{user_id}, income_type=#{income_type}, income_number=#{income_number}, income_date=#{date} where id=#{id} ")
    public int updateIncome(int id, int user_id, String income_type, float income_number, Date date);

    @Delete("delete from income where id=#{id}")
    public int deleteIncome(int id);
}

