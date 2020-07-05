package com.springboot.springbootjavaeeks.controller;

import com.springboot.springbootjavaeeks.mapper.ControllerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cuiwanzhi
 * @date 2020/7/4 16:18
 */
@Controller
public class ControController {
    @Autowired
    ControllerMapper controllerMapper;

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
}
