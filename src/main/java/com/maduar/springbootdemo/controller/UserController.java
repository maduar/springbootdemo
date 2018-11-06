package com.maduar.springbootdemo.controller;


import com.maduar.springbootdemo.amqp.Sender;
import com.maduar.springbootdemo.annotation.ApiVersion;
import com.maduar.springbootdemo.entity.Ma;
import com.maduar.springbootdemo.entity.TUser;
import com.maduar.springbootdemo.form.Aliyun;
import com.maduar.springbootdemo.form.KmailPostForm;
import com.maduar.springbootdemo.form.validator.KmailPostFormValidator;
import com.maduar.springbootdemo.mapping.KemailRepository;
import com.maduar.springbootdemo.mapping.UserRepository;
import com.maduar.springbootdemo.service.kmail.KEmailService;
import com.maduar.springbootdemo.utils.TestAOP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/{version}/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestAOP testAOP;

    @Autowired
    private Aliyun aliyun;

    @PersistenceContext
    protected EntityManager em;

    @Autowired
    private KEmailService kEmailService;

    @Autowired
    private KemailRepository kemailRepository;

    @Autowired
    private Sender sender;

    @Autowired
    private KmailPostFormValidator kmailPostFormValidator;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<TUser> list() {
        return userRepository.findAll();
    }

    @InitBinder
    public void initBinder(DataBinder dataBinder){
        dataBinder.setValidator(kmailPostFormValidator);
    }

    @ApiVersion(99)
    @GetMapping(value = "/hello/{custId}/")
    public String sayHello99(@PathVariable("custId") String custId) {
        System.out.println("custId: " + custId);
//        sender.sendMsg(custId);
        return "sayHello100: " + custId;
    }

    @ApiVersion(22)
    @GetMapping(value = "/hello/{custId}/")
    public HttpEntity<String> sayHello22(@PathVariable("custId") String custId) {
        System.out.println("custId: " + custId);

        sender.sendMsg(custId);

        String result = "sayHello22: " + custId;
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/hello/")
    public HttpEntity<?>  sayHello(HttpServletRequest request) {
        String result = "sayHello";
        System.out.println(aliyun.getAppKey());
        System.out.println(aliyun.getAppSecret());
        System.out.println(aliyun.getBucket());
        System.out.println(aliyun.getEndPoint());
        testAOP.perform();
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/hello/")
    public HttpEntity<?> sayHelloPost(@RequestBody KmailPostForm kmailPostForm) {
//        List<KEmail> list = kemailRepository.findAll();
        Integer tid = kmailPostForm.getKid();
        List<Ma> list = kEmailService.listMaByKid(tid);
        return ResponseEntity.ok(list);
    }

    @PostMapping(value = "/helloPost/")
    public HttpEntity<?> helloPost(@Valid @RequestBody KmailPostForm kmailPostForm, BindingResult result) {
//        List<KEmail> list = kemailRepository.findAll();
        if (result.hasErrors()) {
            return ResponseEntity.ok("error");
        }
        Integer kid = kmailPostForm.getKid();
        return ResponseEntity.ok(kid);
    }

}
