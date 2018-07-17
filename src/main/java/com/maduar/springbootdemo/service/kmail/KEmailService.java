package com.maduar.springbootdemo.service.kmail;

import com.maduar.springbootdemo.entity.Ma;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *
 * @author maduar
 * @date 18/07/2018 12:03 AM
 * @email maduar@163.com
 *
 * */
public interface KEmailService {

    List<Ma> listMa();

    List<Ma> listMaByKid(Integer kid);
}
