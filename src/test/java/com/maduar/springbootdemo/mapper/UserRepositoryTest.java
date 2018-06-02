package com.maduar.springbootdemo.mapper;

import com.maduar.springbootdemo.config.DataSourceConfig;
import com.maduar.springbootdemo.mapping.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

/*
 *
 * @author maduar
 * @date 02/06/2018 11:49 PM
 * @email maduar@163.com
 *
 * */

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(DataSourceConfig.class)
public class UserRepositoryTest {

  @MockBean
  private UserRepository userRepository;

  @Test
  public void testUserJPA() {
    given(this.userRepository.count()).willReturn(2l);
    long count = userRepository.count();
    System.out.println(count);
    assertEquals(1, count);
  }
}
