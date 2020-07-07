package com.springboot.springbootjavaeeks.controller;

import com.springboot.springbootjavaeeks.bean.User;
import com.springboot.springbootjavaeeks.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author cuiwanzhi
 * @date 2020/7/7 12:44
 */
@Slf4j
@Controller
public class UserController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/login")
    public String login(User loginUser, Model model, HttpServletRequest request) {
        if (loginUser.getId() == 0) {//处理root用户

            if (loginUser.getPassword().equals("123456")) {

                loginUser.setName("root");
                request.getSession().setAttribute("user", loginUser);
                request.getSession().setAttribute("level", "root");
                log.info("登录用户" + loginUser.toString());

                return "redirect:/index";
            } else {
                model.addAttribute("msg", "密码错误");
                return "login";
            }
        } else {//处理普通用户
            User user = userMapper.selectUser(loginUser.getId());
            if (user != null && user.getPassword().equals(loginUser.getPassword())) {
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("level", "user");
                return "redirect:/index";
            } else {
                model.addAttribute("msg", "用户名或密码错误");
                return "login";
            }

        }


    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request,Model model){
        if (request.getSession().getAttribute("level")!=null && request.getSession().getAttribute("level").equals("root")) {//处理普通用户和root的不同首页
            List<User> allUser = userMapper.getAllUser();
            model.addAttribute("allUser", allUser);
            return "rootindex";
        } else {

            return "userindex";
        }
    }



}
