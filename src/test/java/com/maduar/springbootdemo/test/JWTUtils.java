package com.maduar.springbootdemo.test;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/*
 *
 * @author maduar
 * @date 05/07/2018 2:57 PM
 * @email maduar@163.com
 *
 * */
public class JWTUtils {
  /*
   * get playload from token
   * */
  public static String getPlayload(String token) {
    DecodedJWT decodedJWT = JWT.decode(token);
    String playload = decodedJWT.getPayload();
    return playload;
  }

  /*
   * decode playload
   * */
  public static String parsePlayload(String token) throws UnsupportedEncodingException {
    String playload = getPlayload(token);
    final Base64 base64 = new Base64();
    byte[] parsePlayload = base64.decode(playload);
    return new String(parsePlayload, "UTF-8");
  }

  /*
   * parse playload to obj
   * */
  public static <T> T getObject(String token, Class<T> c) throws UnsupportedEncodingException {
    String playload = parsePlayload(token);
    T object = (T) JSON.parseObject(playload, c);
    return object;
  }

  public static boolean checkStrInString(String origin, String recmdSign) {

    String[] strArray;

    if (StringUtils.isBlank(origin) || StringUtils.isBlank(recmdSign)) {
      return false;
    }

    strArray = origin.split(",");
    for (String str : strArray) {
      if (!StringUtils.isBlank(str) && recmdSign.equals(str)) {
        return true;
      }
    }

    return false;
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
