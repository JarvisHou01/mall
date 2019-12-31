package com.qdu.config;

import com.qdu.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * springmvc的配置
 */
@Configuration // AnnotationConfigApplicationContext、AnnotationConfigWebApplicationContext
public class MvcConfig implements WebMvcConfigurer {
    /**
     * 配置拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/bootstrap/**")
                .excludePathPatterns("/user/to_login")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/logout")
                .excludePathPatterns("/verifyCode")
                .excludePathPatterns("/user/to_register").
                excludePathPatterns("/user/register");
    }

    /**
     * <mvc:resource location="" mapping=""/>      上传文件的位置
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pics/**") // mapping属性
           .addResourceLocations("file:d:/upload/"); // location
    }

    /**
     * <mvc:view-controller path="/index" view-name="index" />
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("index");
    }
}
