package com.springboot.springbootjavaeeks.controller;

import com.springboot.springbootjavaeeks.bean.User;
import com.springboot.springbootjavaeeks.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cuiwanzhi
 * @date 2020/7/7 17:38
 */
@Slf4j
@Controller
@RequestMapping("/controller")
public class RootController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/insertUser")
    public String insertUser(String name) {
        log.info("insert name =" + name);
        userMapper.insertUser(name);
        return "redirect:/index";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(int id) {
        log.info("delete id ="+id);
        userMapper.deleteUser(id);
        return "redirect:/index";
    }

    @RequestMapping("/restorePassword")
    public String restorePassword(int id) {
        log.info("restorePassword id ="+id);
        userMapper.restorePassword(id);
        return "redirect:/index";
    }
}
