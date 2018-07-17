package com.maduar.springbootdemo.service.kmail.impl;

import com.maduar.springbootdemo.entity.Ma;
import com.maduar.springbootdemo.mapping.KemailRepository;
import com.maduar.springbootdemo.service.kmail.KEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *
 * @author maduar
 * @date 18/07/2018 12:05 AM
 * @email maduar@163.com
 *
 * */
@Service
public class KmailServiceImpl implements KEmailService {

    //这里的单引号不能少，否则会报错，被识别是一个对象
    private static final String CACHE_KEY = "'user'";
    private static final String DEMO_CACHE_NAME = "users";

    @Autowired
    private KemailRepository kemailRepository;

    @Override
    @Cacheable(value=DEMO_CACHE_NAME,key="'user_'+#kid")
    public List<Ma> listMaByKid(Integer kid) {
        System.out.println("kid not cache");
        return kemailRepository.listMaByKid(kid);
    }

    @Override
    @Cacheable(value=DEMO_CACHE_NAME,key="'user_'")
    public List<Ma> listMa() {
        System.out.println("not cache");
        return kemailRepository.listMa();
    }
}
