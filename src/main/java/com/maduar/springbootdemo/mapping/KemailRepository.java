package com.maduar.springbootdemo.mapping;

import com.maduar.springbootdemo.entity.KEmail;
import com.maduar.springbootdemo.entity.Ma;
import com.maduar.springbootdemo.entity.TUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;

/*
 *
 * @author maduar
 * @date 17/07/2018 7:24 PM
 * @email maduar@163.com
 *
 * */
public interface KemailRepository extends
        JpaRepository<KEmail, Long>,
        JpaSpecificationExecutor<KEmail>,
        Serializable {


    @Query(value = "  SELECT new com.maduar.springbootdemo.entity.Ma(a.tId, b.kemail) " +
            " FROM  com.maduar.springbootdemo.entity.TUser AS a, com.maduar.springbootdemo.entity.KEmail AS b WHERE a.tId = b.tId ")
    List<Ma> listMa();

    @Query(value = "  SELECT new com.maduar.springbootdemo.entity.Ma(a.tId, b.kemail) " +
            " FROM  com.maduar.springbootdemo.entity.TUser AS a, com.maduar.springbootdemo.entity.KEmail AS b WHERE a.tId = b.tId " +
            " AND b.kid = ?1 ")
    List<Ma> listMaByKid(@Param("kid") Integer kid);



}
