package com.springboot.springbootjavaeeks.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cuiwanzhi
 * @date 2020/7/4 15:06
 */
public class LoginHand implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getSession().getAttribute("user")==null){
            request.setAttribute("msg", "请登录");
            request.getRequestDispatcher("/").forward(request, response);
            return false;
        }
        else {

            return true;
        }
    }
}
