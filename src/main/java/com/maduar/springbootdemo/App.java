package com.maduar.springbootdemo;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableCaching
@NacosPropertySource(dataId = "springbootdemo", autoRefreshed = true)
public class App {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(App.class, args);

//        System.setProperty("java.awt.headless", "false");
//        Desktop.getDesktop().browse(new URI("http://127.0.0.1:9090/@in"));
    }
}
