package com.maduar.springbootdemo.form;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
 *
 * @author maduar
 * @date 30/07/2018 5:41 PM
 * @email maduar@163.com
 *
 * */
@Component
public class TestForm {

    @Value("${test}")
    private String test;

    public String getTestValue() {
        return test;
    }
}
