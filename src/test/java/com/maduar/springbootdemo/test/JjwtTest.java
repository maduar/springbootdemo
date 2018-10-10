package com.maduar.springbootdemo.test;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import javax.validation.constraints.NotNull;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

/*
 *
 * @author maduar
 * @date 08/07/2018 1:21 AM
 * @email maduar@163.com
 *
 * */
public class JjwtTest {

  @Test
  public void test() {
    Key key = MacProvider.generateKey();

    Map<String, Object> headerClaims = new HashMap();
    headerClaims.put("alg", "HS256");
    headerClaims.put("typ", "JWT");

    Playload playload = new Playload("000044", "danny.pang@ebizprise.com", "15800637472");
    String saltKey = "020BFC96";

    String jj = JSON.toJSONString(playload);
    System.out.println(jj);

    String compactJws = Jwts.builder()
        .setHeader(headerClaims)
        .setPayload(jj)
        .signWith(SignatureAlgorithm.HS512, saltKey)
        .compact();

    System.out.println(compactJws);
  }

  public static <T> String createJwtToken(T t, @NotNull String saltKey) {
    if (t == null || StringUtils.isBlank(saltKey)) {
      return null;
    }

    Map<String, Object> headerClaims = new HashMap();
    headerClaims.put("alg", "HS256");
    headerClaims.put("typ", "JWT");

    String playload = JSON.toJSONString(t);
    String jwtToken = Jwts.builder()
        .setHeader(headerClaims)
        .setPayload(playload)
        .signWith(SignatureAlgorithm.HS512, saltKey)
        .compact();

    return jwtToken;
  }
}
