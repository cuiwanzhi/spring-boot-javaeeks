package com.springboot.springbootjavaeeks.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author cuiwanzhi
 * @date 2020/7/4 14:30
 */

/**
 * id int(11) primary key AUTO_INCREMENT,	#用户ID
 *                      user_name varchar(255) NOT NULL,				#用户名
 *                      password	varchar(255) NOT NULL,				#用户密码
 *                      name varchar(255) NOT NULL,							#用户姓名
 *                      gender varchar(255) NOT NULL,						#用户性别
 *                      birthday date,													#出生日期
 *                      contact varchar(255) NOT NULL,					#联系方式
 *                      e_mail varchar(255) NOT NULL						#电子邮箱
 */
@Component
@Data
public class User {
    private int id;
    private String user_name;
    private String password;
    private String name;
    private String gender;
    private Date birthday;
    private String contact;
    private String e_mail;
}
