package com.springboot.springbootjavaeeks.bean;

import org.springframework.core.convert.converter.Converter;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cuiwanzhi
 * @date 2020/7/4 22:27
 */

@Component
public class MyDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(s);
        } catch (ParseException | java.text.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}