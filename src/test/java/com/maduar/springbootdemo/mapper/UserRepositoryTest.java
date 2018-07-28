package com.maduar.springbootdemo.mapper;

import com.maduar.springbootdemo.config.DataSourceConfig;
import com.maduar.springbootdemo.mapping.UserRepository;
import com.maduar.springbootdemo.soundsystem.CDPlayer;
import com.maduar.springbootdemo.soundsystem.CDPlayerConfig;
import com.maduar.springbootdemo.soundsystem.CompactDisc;
import com.maduar.springbootdemo.validator.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

/*
 *
 * @author maduar
 * @date 02/06/2018 11:49 PM
 * @email maduar@163.com
 *
 * */

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@Import(DataSourceConfig.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class UserRepositoryTest {

//  @MockBean
//  private UserRepository userRepository;
//
//  @Autowired
//  private CDPlayer cdPlayer;

  @Test
  public void testUserJPA() {
//    given(this.userRepository.count()).willReturn(2l);
//    long count = userRepository.count();
//    System.out.println(count);
//    assertEquals(1, count);
//    cdPlayer.play();
//    assertNotNull(cdPlayer);

    Person person = new Person();
    person.setAge(999);
    System.out.println(person.toString());
  }
}
