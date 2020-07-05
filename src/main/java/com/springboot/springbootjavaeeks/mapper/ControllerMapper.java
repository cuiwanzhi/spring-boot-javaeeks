package com.springboot.springbootjavaeeks.mapper;

import com.springboot.springbootjavaeeks.bean.Controller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author cuiwanzhi
 * @date 2020/7/5 22:11
 */
@Mapper
public interface ControllerMapper {
    @Select("select * from controller where id=#{id}")
    public Controller getController(int id);
}
