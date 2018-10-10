package com.maduar.springbootdemo.date;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 *
 * @author maduar
 * @date 06/08/2018 2:49 PM
 * @email maduar@163.com
 *
 * */
public class DateTest {

    final String defaultDate1 = "20170901";
    final String defaultDate2 = "10170901";

    final String defaultDate3 = "20171190";
    final String defaultDate4 = "20172910";
    final String defaultDate5 = "20170940";

    final String defaultDate6 = null;
    final String defaultDate7 = "";

    @Test
    public void test() {

        Assert.assertTrue(isDateYYYYMMDD(defaultDate1));
        Assert.assertTrue(isDateYYYYMMDD(defaultDate2));

        Assert.assertFalse(isDateYYYYMMDD(defaultDate3));
        Assert.assertFalse(isDateYYYYMMDD(defaultDate4));
        Assert.assertFalse(isDateYYYYMMDD(defaultDate5));

        Assert.assertFalse(isDateYYYYMMDD(defaultDate6));
        Assert.assertFalse(isDateYYYYMMDD(defaultDate7));

    }


    public boolean isDateYYYYMMDD(String date) {

        if (date == null || "".equals(date)) {
            return false;
        }

        final String REGEX = "^[012]\\d{3}[01]\\d[0123]\\d$";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(date); // 获取 matcher 对象

        return m.matches();
    }
}
