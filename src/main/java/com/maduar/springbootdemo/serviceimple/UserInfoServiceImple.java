package com.maduar.springbootdemo.serviceimple;

import com.maduar.springbootdemo.entity.TUser;
import com.maduar.springbootdemo.mapping.UserRepository;
import com.maduar.springbootdemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *
 * @author maduar
 * @date 31/05/2018 11:08 PM
 * @email maduar@163.com
 *
 * */

@Service
public class UserInfoServiceImple implements UserInfoService{



  @Autowired
  private UserRepository userRepository;


  @Override
  public List<TUser> findAll() {
    return userRepository.findAll();
  }

  @Override
  public long count() {
    return userRepository.count();
  }
}
