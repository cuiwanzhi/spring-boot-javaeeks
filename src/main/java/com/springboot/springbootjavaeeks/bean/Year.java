package com.springboot.springbootjavaeeks.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author cuiwanzhi
 * @date 2020/7/4 14:43
 */

/**
 * id int(11) primary key AUTO_INCREMENT,		#支出ID
 *                      user_id int(11),													#用户ID
 *                      year_type varchar(255) NOT NULL,					#备注
 *                      year_number decimal(10, 2),								#支出金额
 *                      year_year varchar(10),
 *                      year_date date,														#支出日期
 *                      FOREIGN KEY(user_id) REFERENCES user(id)	#增加外键
 */
@Component
@Data
public class Year {
    private int id;
    private int user_id;
    private String year_type;//备注
    private float year_number;

    private Date year_date;
}
