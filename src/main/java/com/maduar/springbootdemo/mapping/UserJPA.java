package com.maduar.springbootdemo.mapping;

import com.maduar.springbootdemo.entity.TUser;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserJPA extends
    JpaRepository<TUser, Long>,
    JpaSpecificationExecutor<TUser>,
    Serializable {

}
