package com.maduar.springbootdemo.mail;

import com.maduar.springbootdemo.base.BaseSet;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Date;

/*
 *
 * @author maduar
 * @date 20/08/2018 2:42 PM
 * @email maduar@163.com
 *
 * */
public class MailTest extends BaseSet {

    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    public void testMail() {
        SimpleMailMessage message = new SimpleMailMessage();

        String from = "maduar@163.com";
        String to = "maduar@163.com";

        message.setFrom(from);
        message.setTo(to);
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");

        javaMailSender.send(message);
    }
}
