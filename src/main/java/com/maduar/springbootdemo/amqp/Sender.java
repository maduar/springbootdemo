package com.maduar.springbootdemo.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 *
 * @author maduar
 * @date 14/08/2018 5:49 PM
 * @email maduar@163.com
 *
 * */
//@Component
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String content) {
        rabbitTemplate.convertAndSend(content);
        System.out.println("发送消息: '" + content + "'");
    }

}


