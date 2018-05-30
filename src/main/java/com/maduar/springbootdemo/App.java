package com.maduar.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class App {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(App.class, args);
    }
}
