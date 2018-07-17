package com.maduar.springbootdemo.controller;


import com.maduar.springbootdemo.entity.KEmail;
import com.maduar.springbootdemo.entity.Ma;
import com.maduar.springbootdemo.entity.TUser;
import com.maduar.springbootdemo.form.KmailPostForm;
import com.maduar.springbootdemo.mapping.KemailRepository;
import com.maduar.springbootdemo.mapping.UserRepository;
import com.maduar.springbootdemo.service.kmail.KEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private KEmailService kEmailService;

    @Autowired
    private KemailRepository kemailRepository;

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
    public HttpEntity<?> sayHelloPost(@RequestBody KmailPostForm kmailPostForm) {
//        List<KEmail> list = kemailRepository.findAll();
        Integer tid = kmailPostForm.getKid();
        List<Ma> list = kEmailService.listMaByKid(tid);
        return ResponseEntity.ok(list);
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
