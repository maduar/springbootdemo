package com.maduar.springbootdemo.test;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 *
 * @author maduar
 * @date 02/07/2018 10:18 AM
 * @email maduar@163.com
 *
 * */
public class JWTTest {

  @Test
  public void test() throws UnsupportedEncodingException {

    // 1. create head
    Map<String, Object> headerClaims = new HashMap();
    headerClaims.put("alg", "HS256");
    headerClaims.put("typ", "JWT");

    try {
      // 2. create signture
      Algorithm algorithm = Algorithm.HMAC256("020BFC96");
      String token = JWT.create()
          .withHeader(headerClaims)
          .withClaim("sub", "000231") // 2. create playload
          .sign(algorithm);

      String result = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9.TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ";
      System.out.println("token: " + token);
      Assert.assertEquals(token, result);

    } catch (JWTCreationException exception){
      //Invalid Signing configuration / Couldn't convert Claims.
      exception.printStackTrace();
    }
  }

  @Test
  public void test2() {
    String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9.TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ";
    String[] arrayStr = token.split(" ");
    System.out.println("arrayStr " + Arrays.toString(arrayStr));

    String result = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9.TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ";

    Assert.assertEquals("Bearer", arrayStr[0]);
    Assert.assertEquals(result, arrayStr[1]);
    Assert.assertEquals(arrayStr.length, 2);
  }

  @Test
  public void test3() throws UnsupportedEncodingException{
    final Base64 base64 = new Base64();
    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIwMDAyMzEifQ.4j2RCvqR7yyrNrE1-dBFKllhXpBjwMOrQUiWATpFJQI";
    String custIdDefault = "000231";
    String custId;

    try {
      Playload pl = JWTUtils.getObject(token, Playload.class);
      custId = pl.getCustId();
      System.out.println("custId: " + custId);
      Assert.assertEquals(custIdDefault, custId);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

  }

  @Test
  public void test4() throws UnsupportedEncodingException {
    Playload playload = new Playload("000231", "danny.pang@ebizprise.com", "15800637472");
    String saltKey = "020BFC96";

    String token = createJwtToken(playload, saltKey);

//    String defaultToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjdXN0SWQiOiIwMDAyMzEiLCJlbWFpbCI6ImRhbm55LnBhbmdAZWJpenByaXNlLmNvbSIsIm1vYmlsZV9waG9uZSI6IjE1ODAwNjM3NDcyIn0.YnOy2O-o65x-7miY07zr3oMXXjoptR3GRzYWCp8eQTI";
    String defaultToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjdXN0SWQiOiIwMDAyMzEiLCJlbWFpbCI6ImRhbm55LnBhbmdAZWJpenByaXNlLmNvbSIsIm1vYmlsZV9waG9uZSI6IjE1ODAwNjM3NDcyIn0.YnOy2O-o65x-7miY07zr3oMXXjoptR3GRzYWCp8eQTI";

    System.out.println("token: " + token);
    Assert.assertEquals(defaultToken, token);

  }

  public static <T> String createJwtToken(T t, @NotNull String saltKey) {
    if (t == null || StringUtils.isBlank(saltKey)) {
      return null;
    }

    Map<String, Object> headerClaims = new LinkedHashMap<String, Object>();
    headerClaims.put("alg", "HS256");
    headerClaims.put("typ", "JWT");

    String key = TextCodec.BASE64.encode(saltKey);

    String playload = JSON.toJSONString(t);
    String jwtToken = Jwts.builder()
        .setHeader(headerClaims)
        .setPayload(playload)
        .signWith(SignatureAlgorithm.HS256, key)
        .compact();

    return jwtToken;
  }
}
