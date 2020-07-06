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
        registry.addViewController("/login").setViewName("login");

    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHand()).addPathPatterns("/**").excludePathPatterns("/").excludePathPatterns("/login").excludePathPatterns("/controllerlogin").excludePathPatterns("/controller").excludePathPatterns("/druid/*");
    }
}
