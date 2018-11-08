package com.maduar.springbootdemo.enums;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
 *
 * @author maduar
 * @date 11/08/2018 11:02 AM
 * @email maduar@163.com
 *
 * */
@Data
@NoArgsConstructor
@Component
public class ConfigEnum {

    @Value("${appKey}")
    private String appKey;

    @Value("${appSecret}")
    private String appSecret;

    @Value("${bucket}")
    private String bucket;

    @Value("${endPoint}")
    private String endPoint;

    @Value("${config.rabbitmq.pass}")
    private String rabbitmqPass;

}
