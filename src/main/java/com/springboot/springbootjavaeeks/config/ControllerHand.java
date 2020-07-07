package com.springboot.springbootjavaeeks.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cuiwanzhi
 * @date 2020/7/4 15:06
 */
@Slf4j
public class ControllerHand implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getSession().getAttribute("level") == null || !request.getSession().getAttribute("level").equals("root")) {
            log.debug(request.getSession().getAttribute("level").toString());
            System.out.println();
            request.setAttribute("msg", "权限不够");
            request.getRequestDispatcher("/index").forward(request, response);
            return false;
        } else {

            return true;
        }
    }
}
