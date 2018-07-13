package com.maduar.springbootdemo.controller;


import com.maduar.springbootdemo.entity.TUser;
import com.maduar.springbootdemo.mapping.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    protected EntityManager em;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<TUser> list() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/hello/{custId}/")
    public String sayHello(@PathVariable("custId") String custId) {
        System.out.println("custId: " + custId);
        return "hello24" + custId;
    }

    @GetMapping(value = "/hello/")
    public String sayHello(HttpServletRequest request) {
        return "hello_get";
    }

    @PostMapping(value = "/hello/")
    public String sayHelloPost() {
        TUser t = new TUser();
        t.settId(1);
        t.settName("1");
        t.settAge(1);
        t.settAddress("1");

        List<TUser> tUsers = new ArrayList<TUser>();
        tUsers.add(t);
        batchInsert(tUsers);
        return "hello_post";
    }

    @Transactional
    public void batchInsert(List list) {
        for (int i = 0; i < list.size(); i++) {

            em.persist(list.get(i));

            if (i % 20 == 0) {

                em.flush();

                em.clear();

            }

        }

    }
}
