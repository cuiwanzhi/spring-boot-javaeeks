package com.springboot.springbootjavaeeks.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author cuiwanzhi
 * @date 2020/7/7 12:07
 */
@Component
@Data
public class User {
    private int id;
    private String name;
    private String password;
    private String gender;//性别
    private String contact;//联系电话
    private String e_mail;//电子邮箱
    private int complete;//填充信息
}
