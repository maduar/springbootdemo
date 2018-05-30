package com.maduar.springbootdemo.controller;


import com.maduar.springbootdemo.entity.TUser;
import com.maduar.springbootdemo.mapping.UserJPA;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserJPA userJPA;

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public List<TUser> list() {
        return userJPA.findAll();
    }

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String sayHello() {


        return "hello";
    }
}
