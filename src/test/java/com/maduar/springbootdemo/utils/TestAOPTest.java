package com.maduar.springbootdemo.utils;

import com.maduar.springbootdemo.base.BaseSet;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/*
 *
 * @author maduar
 * @date 10/10/2018 2:40 PM
 * @email maduar@163.com
 *
 * */
public class TestAOPTest {

    private TestAOP testAOP;

    @Before
    public void testBefore() {
        testAOP = new TestAOP();
    }

    @Test
    public void tesT() {
        testAOP.perform();
    }
}
