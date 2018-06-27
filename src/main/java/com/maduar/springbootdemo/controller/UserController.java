package com.maduar.springbootdemo.controller;


import com.maduar.springbootdemo.entity.TUser;
import com.maduar.springbootdemo.mapping.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        return "hello2" + custId;
    }
}
