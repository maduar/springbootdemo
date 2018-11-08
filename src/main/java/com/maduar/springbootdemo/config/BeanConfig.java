package com.maduar.springbootdemo.config;

import com.maduar.springbootdemo.enums.ConfigEnum;
import com.maduar.springbootdemo.form.Aliyun;
import com.maduar.springbootdemo.utils.DESUtils;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/*
 *
 * @author maduar
 * @date 11/08/2018 10:56 AM
 * @email maduar@163.com
 *
 * */
@SpringBootConfiguration
public class BeanConfig {

    @Autowired
    private ConfigEnum configEnum;

    @Bean
    public Aliyun aliyun(){
        return Aliyun.options()
                .setAppKey(configEnum.getAppKey())
                .setAppSecret(configEnum.getAppSecret())
                .setBucket(configEnum.getBucket())
                .setEndPoint(configEnum.getEndPoint())
                .build();
    }

    @Bean
    CachingConnectionFactory myConnectionFactory() {

        String pass = DESUtils.decode(configEnum.getRabbitmqPass());
//        String pass = "rabbitMaduar310";

        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword(pass);
        connectionFactory.setHost("150.109.49.131");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        return connectionFactory;
    }

    @Bean
    Exchange myExchange() {
        return ExchangeBuilder.topicExchange("test.topic").durable().build();
    }

    @Bean
    Queue myQueue() {
        return QueueBuilder.durable("myQueue").build();
    }

    @Bean
    public Binding myExchangeBinding(@Qualifier("myExchange") Exchange topicExchange,
                                     @Qualifier("myQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(topicExchange).with("test.#").noargs();
    }

    @Bean
    public RabbitTemplate myExchangeTemplate(CachingConnectionFactory myConnectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(myConnectionFactory);
        rabbitTemplate.setExchange("test.topic");
        rabbitTemplate.setRoutingKey("test.abc.123");
        return rabbitTemplate;
    }

}
