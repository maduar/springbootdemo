package com.maduar.springbootdemo.service;

import com.maduar.springbootdemo.entity.TUser;

import java.util.List;

/*
 *
 * @author maduar
 * @date 31/05/2018 11:07 PM
 * @email maduar@163.com
 *
 * */
public interface UserInfoService {
  public List<TUser> findAll();

  public long count();
}
