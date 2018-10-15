package com.maduar.springbootdemo.service.kmail.impl;

import com.maduar.springbootdemo.service.TddTestService;
import org.springframework.stereotype.Service;

/*
 *
 * @author maduar
 * @date 26/09/2018 6:02 PM
 * @email maduar@163.com
 *
 * */
@Service
public class TddTestServiceImpl implements TddTestService {
    @Override
    public String test() {
        return "OK";
    }
}
