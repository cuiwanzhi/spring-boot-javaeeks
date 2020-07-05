package com.springboot.springbootjavaeeks.controller;

import com.springboot.springbootjavaeeks.bean.MyDateConverter;
import com.springboot.springbootjavaeeks.bean.User;
import com.springboot.springbootjavaeeks.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cuiwanzhi
 * @date 2020/7/4 16:17
 */
@Slf4j
@Controller
public class UserController {
    @Autowired
    MyDateConverter myDateConverter;

    @Autowired
    UserMapper userMapper;

    //@ResponseBody
    @RequestMapping("/userlogin")
    public String userLogin(User loginUser, Model model, HttpServletRequest request) {
        User user = userMapper.getUser(loginUser.getId());
        if (user!=null && user.getPassword().equals(loginUser.getPassword())) {
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("level", "user");
            model.addAttribute("msg", "登录成功");
            log.debug("登录：" + user.toString());
            return "index";
        } else {
            model.addAttribute("msg", "账号或密码错误");
            log.error("登录失败：" + loginUser.toString());
            return "login";
        }

    }

    @RequestMapping("/userUnlogin")
    public String userUnLogin(Model model, HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "login";
    }

    @RequestMapping("/updataPassword")
    public String updataPassword(HttpServletRequest request, Model model, String oldPassword, String newPassword1, String newPassword2) {
        if (!newPassword1.equals(newPassword2)) {
            model.addAttribute("msg", "两次输输入的新密码不一致");
            return "updataPassword";
        } else {
            User user = (User) request.getSession().getAttribute("user");
            if (!user.getPassword().equals(oldPassword)) {
                model.addAttribute("msg", "旧密码不符合");
                return "updataPassword";
            } else {
                userMapper.updataPassword(newPassword1, user.getId());
                request.getSession().removeAttribute("user");
                model.addAttribute("msg", "密码需改成功，请重新登录");
                return "redirect:/login";
            }
        }

    }

    @RequestMapping("/updateMessage")
    public String updateName(User user,HttpServletRequest request,String UserBirthday) {
        user.setBirthday(myDateConverter.convert(UserBirthday));
        User user1 = (User) request.getSession().getAttribute("user");
        user.setId(user1.getId());
        log.debug(String.valueOf(user.getId()));
        userMapper.updateMessage(user.getId(),user.getUser_name(), user.getName(), user.getGender(), user.getBirthday(), user.getContact(),user.getE_mail());

        request.getSession().removeAttribute("user");
        request.getSession().setAttribute("user", userMapper.getUser(user1.getId()));

        return "index";

    }

    @RequestMapping("/getMessage")
    public String getMessage(HttpServletRequest  request,Model model) {
        User loginUser = (User) request.getSession().getAttribute("user");
        User user = userMapper.getUser(loginUser.getId());
        model.addAttribute("user", user);
        return "updateMessage";
    }


    @RequestMapping("/getNumber")
    public String getNumber(HttpServletRequest request , Model model) {
        User user = (User) request.getSession().getAttribute("user");
        float income =userMapper.getIncome(user.getId());
        float year =userMapper.getIncome(user.getId());
        float sum = income + year;
        income = income/sum;
        year = year / sum;
        model.addAttribute("income", income);
        model.addAttribute("year", year);
        return "table";
    }


}
