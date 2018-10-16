package com.maduar.springbootdemo.reflectASM;

import com.esotericsoftware.reflectasm.MethodAccess;
import org.junit.Assert;

/*
 *
 * @author maduar
 * @date 15/07/2018 11:34 PM
 * @email maduar@163.com
 *
 * */
public class Test {


    @org.junit.Test
    public void test() {
        Playload playload = new Playload();
        MethodAccess access = MethodAccess.get(Playload.class);
        int addNameIndex = access.getIndex("setCustId");
        System.out.println("add: " + addNameIndex);
        access.invoke(playload, addNameIndex, "Awesome McLovin");
        String name = (String)access.invoke(playload, "getCustId");

        String result = "Awesome McLovin";
        System.out.println(playload.toString());
        Assert.assertEquals(result, name);

    }
}
