package com.maduar.springbootdemo.base;

import com.maduar.springbootdemo.App;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 *
 * @author maduar
 * @date 31/07/2018 4:28 PM
 * @email maduar@163.com
 *
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseSet {
}
