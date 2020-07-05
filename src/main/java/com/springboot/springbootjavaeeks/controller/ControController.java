package com.springboot.springbootjavaeeks.controller;

import com.springboot.springbootjavaeeks.bean.MyDateConverter;
import com.springboot.springbootjavaeeks.bean.User;
import com.springboot.springbootjavaeeks.mapper.ControllerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author cuiwanzhi
 * @date 2020/7/4 16:18
 */
@Controller
public class ControController {
    @Autowired
    ControllerMapper controllerMapper;

    @Autowired
    MyDateConverter myDateConverter;

    @RequestMapping("/controllerLogin")
    public String controllerLogin(com.springboot.springbootjavaeeks.bean.Controller logincontroller, Model model, HttpServletRequest request) {
        com.springboot.springbootjavaeeks.bean.Controller controller = controllerMapper.getController(logincontroller.getId());
        if (controller.getPassword().equals(logincontroller.getPassword())) {
            request.getSession().setAttribute("user", controller);
            request.getSession().setAttribute("level", "controller");
            return "controllerIndex";
        }
        return "controllerLogin";
    }

    @RequestMapping("/getAllUser")
    public String getAllUser(Model model,HttpServletRequest request) {
        List<User> allUser = controllerMapper.getAllUser();
        model.addAttribute("allUser", allUser);
        return "selectUser";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(User user) {
        controllerMapper.deleteUser(user.getId());
        return "redirect:/getAllUser";
    }

    @RequestMapping("/updateUserPassword")
    public String selectUser(Model model,User user) {
        controllerMapper.updateUserPassword(user.getId());
        model.addAttribute("msg", "密码还原成功");
        return "forward:/getAllUser";
    }

}
