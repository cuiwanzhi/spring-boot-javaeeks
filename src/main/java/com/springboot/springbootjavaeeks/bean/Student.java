package com.springboot.springbootjavaeeks.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author cuiwanzhi
 * @date 2020/7/7 12:20
 */

@Component
@Data
public class Student {
    private int id;
    private String name;
    private String gender;  //性别
    private int  grade;//年级
    private int stu_class;//原班级
    private String pickup;//接送情况
    private String midday;//午托情况
    private Date in_date;//录入时间
    private String user_name;//录入人
    private String last_update_name;//最后修改人


}
