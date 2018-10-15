package com.maduar.springbootdemo.utils;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 *
 * @author maduar
 * @date 04/08/2018 9:33 PM
 * @email maduar@163.com
 *
 * */
@Aspect
@Component
public class Audience {

    @Before(" execution(** com.maduar.springbootdemo.utils.TestAOP.perform(..)) ")
    public void silenceCellPhones() {
        System.out.println(" Silencing cell phones ");
    }

    @AfterReturning(" execution(** com.maduar.springbootdemo.utils.TestAOP.perform(..)) ")
    public void applause() {
        System.out.println(" CLAP CLAP CLAP!!! ");
    }
}
