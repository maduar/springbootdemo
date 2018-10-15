package com.maduar.springbootdemo.config;

import com.maduar.springbootdemo.annotation.ApiVersionRequestMappingHandlerMapping;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/*
 *
 * @author maduar
 * @date 13/08/2018 6:16 PM
 * @email maduar@163.com
 *
 * */
@SpringBootConfiguration
public class WebConfig extends WebMvcConfigurationSupport {

//    @Bean
//    public AuthInterceptor interceptor(){
//        return new AuthInterceptor();
//    }
//
//    @Bean
//    public JWTInterceptor jWTInterceptor() {
//        return new JWTInterceptor();
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(jWTInterceptor()).addPathPatterns("/**"); //对来自/** 全路径请求进行拦截
//        registry.addInterceptor(interceptor());
    }

    @Override
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = new ApiVersionRequestMappingHandlerMapping();
        handlerMapping.setOrder(0);
        handlerMapping.setInterceptors(getInterceptors());
        return handlerMapping;
    }
}
