package com.springboot.springbootjavaeeks.mapper;

import com.springboot.springbootjavaeeks.bean.Income;
import com.springboot.springbootjavaeeks.bean.Year;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @author cuiwanzhi
 * @date 2020/7/5 15:30
 */
@Mapper
public interface YearMapper {
    @Select("select * from year ")
    public List<Year> getAllYear();

    @Select("select * from year where id=#{id}")
    public Year selectYear(int id);

    @Select("select * from year where user_id=#{user_id}")
    public List<Year> getUserYear(int user_id);

    @Insert("insert into year(user_id, year_type, year_number, year_date) values (#{user_id},#{year_type},#{year_number},#{year_date});")
    public int insertYear(int user_id, String year_type, float year_number, Date year_date);

    @Update("update year set user_id=#{user_id}, year_type=#{year_type}, year_number=#{year_number}, year_date=#{date} where id=#{id} ")
    public int updateYear(int id, int user_id, String year_type, float year_number, Date date);

    @Delete("delete from year where id=#{id}")
    public int deleteYear(int id);
}

