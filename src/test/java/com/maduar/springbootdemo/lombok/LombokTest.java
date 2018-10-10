package com.maduar.springbootdemo.lombok;

import com.maduar.springbootdemo.form.LombokForm;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/*
 *
 * @author maduar
 * @date 06/08/2018 5:04 PM
 * @email maduar@163.com
 *
 * */
public class LombokTest {

    @Test
    public void test() {

        String defaultName = "aaa";
        int defaultAge = 10;

        LombokForm lombokForm = new LombokForm(defaultName, defaultAge);
        String str = lombokForm.toString();

        String name = lombokForm.getName();
        int age = lombokForm.getAge();

        System.out.println(lombokForm.toString());
        Assert.assertEquals(defaultName, name);
        Assert.assertEquals(defaultAge, age);

    }
}
