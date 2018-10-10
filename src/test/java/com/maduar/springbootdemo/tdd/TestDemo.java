package com.maduar.springbootdemo.tdd;

import com.maduar.springbootdemo.base.BaseSet;
import com.maduar.springbootdemo.service.TddTestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/*
 *
 * @author maduar
 * @date 26/09/2018 5:56 PM
 * @email maduar@163.com
 *
 * */
@Slf4j
public class TestDemo extends BaseSet {


    @Autowired
    private TddTestService tddTest;

    @Test
    public void test() {
        String testStr = "OK";
        String result = tddTest.test();

        Assert.assertEquals(testStr, result);
    }
}
