package com.maduar.springbootdemo.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/*
 *
 * @author maduar
 * @date 13/08/2018 5:50 PM
 * @email maduar@163.com
 *
 * */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion {
    int value();
}

