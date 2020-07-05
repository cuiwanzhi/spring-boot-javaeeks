package com.springboot.springbootjavaeeks.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author cuiwanzhi
 * @date 2020/7/4 14:52
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/user").setViewName("login");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("//insertYear.html").setViewName("insertYear");
        registry.addViewController("/controller").setViewName("controller");
        registry.addViewController("/controllerIndex").setViewName("controllerIndex");
        registry.addViewController("/insertIncome.html").setViewName("insertIncome");
        registry.addViewController("/changePassword").setViewName("updataPassword");
        registry.addViewController("/controller").setViewName("controllerLogin");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHand()).addPathPatterns("/**").excludePathPatterns("/").excludePathPatterns("/login").excludePathPatterns("/userlogin").excludePathPatterns("/controllerLogin").excludePathPatterns("/controller").excludePathPatterns("/druid/*");
    }
}
