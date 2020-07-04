package com.springboot.springbootjavaeeks.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author cuiwanzhi
 * @date 2020/7/4 14:35
 */

/**
 * id int(11) primary key AUTO_INCREMENT,	#管理员ID
 *                            controller_name varchar(255) NOT NULL,	#用户名
 *                            password	varchar(255) NOT NULL,				#管理员密码
 *                            name varchar(255) NOT NULL,							#管理员姓名
 *                            gender varchar(255) NOT NULL,						#管理员性别
 *                            contact varchar(255) NOT NULL						#联系方式
 */
@Component
@Data
public class UserController {
    private  int id;
    private String controller_name;
    private String password;
    private String name;
    private String gender;
    private String contact;
}
