package com.maduar.springbootdemo.form;

import lombok.*;
import org.springframework.stereotype.Component;

/*
 *
 * @author maduar
 * @date 06/08/2018 5:05 PM
 * @email maduar@163.com
 *
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LombokForm {

    private String name;
    private int age;

}
