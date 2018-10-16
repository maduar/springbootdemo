package com.maduar.springbootdemo.amqp;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/*
 *
 * @author maduar
 * @date 14/08/2018 5:50 PM
 * @email maduar@163.com
 *
 * */
//@Component
public class Receiver {

    @RabbitListener(queues = "myQueue")
    public void processMessage(Message message) {
        byte[] body = message.getBody();
        System.out.println("收到消息: '" + new String(body) + "'");
    }

}

