package com.maduar.springbootdemo.test;

import com.maduar.springbootdemo.form.TestForm;
import com.maduar.springbootdemo.soundsystem.CDPlayerConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 *
 * @author maduar
 * @date 30/07/2018 5:44 PM
 * @email maduar@163.com
 *
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestForm.class)
public class TestConfig {

    @Autowired
    private TestForm testForm;

    @Test
    public void test() {
        String t = testForm.getTestValue();
        String result = "test";
        System.out.println("-------------");
        System.out.println("t: " + t);
        System.out.println("-------------");

        Assert.assertEquals(t, result);
    }
}
