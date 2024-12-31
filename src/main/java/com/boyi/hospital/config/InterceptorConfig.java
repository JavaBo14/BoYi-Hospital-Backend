//package com.boyi.hospital.config;
//
//import com.boyi.hospital.aop.LoginInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class InterceptorConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 设置登录页不用拦截，同时添加/api/doc.html路径也不拦截
//        registry.addInterceptor(new LoginInterceptor());
////                .addPathPatterns("/**")
////                .excludePathPatterns("/login", "/api/doc.html");
//    }
//}