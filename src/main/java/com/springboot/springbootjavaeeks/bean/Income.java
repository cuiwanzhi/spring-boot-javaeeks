package com.springboot.springbootjavaeeks.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author cuiwanzhi
 * @date 2020/7/4 14:38
 */

/**
 * id int(11) primary key AUTO_INCREMENT,		#收入ID
 *                        user_id int(11),													#用户ID
 *                        income_type varchar(255) NOT NULL,				#收入类型
 *                        income_number decimal(10, 2),							#收入金额
 *                        income_year varchar(10) ,                      #年份
 *                        income_date date,												#收入日期
 *                        FOREIGN KEY(user_id) REFERENCES user(id)	#增加外键
 */
@Component
@Data
public class Income {
    private int id;
    private int user_id;
    private String income_type;
    private float income_number;
    private String income_year;
    private Date income_date;

}
