package com.maduar.springbootdemo.controller;


import com.maduar.springbootdemo.entity.TUser;
import com.maduar.springbootdemo.mapping.UserRepository;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public List<TUser> list() {
        return userRepository.findAll();
    }

    @GetMapping(value="/hello/{custId}/")
    public String sayHello(@PathVariable("custId") String custId) {
        System.out.println("custId: " + custId);
        return "hello24" + custId;
    }

    @GetMapping(value="/hello/")
    public String sayHello(HttpServletRequest request) {
        return "hello_get";
    }

    @PostMapping(value="/hello/")
    public String sayHelloPost() {
        return "hello_post";
    }
}
