package com.maduar.springbootdemo.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/*
 *
 * @author maduar
 * @date 02/07/2018 5:12 PM
 * @email maduar@163.com
 *
 * */
public class JWTInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json; charset=utf-8");
    PrintWriter out = null ;

    String token = request.getHeader("authorization");
    if (token == null) {
      JSONObject res = new JSONObject();
      res.put("success","false");
      res.put("msg","xxxx");
      out = response.getWriter();
      out.append(res.toString());

      return false;
    }

    String[] arrayStr = token.split(" ");
    String resultToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9.TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ";

    String sign = "Bearer";
    if (arrayStr.length == 2 && sign.equalsIgnoreCase(arrayStr[0]) && resultToken.equals(arrayStr[1])) {
      return true;
    }
    JSONObject res = new JSONObject();
    res.put("success","false");
    res.put("msg","xxxx");
    out = response.getWriter();
    out.append(res.toString());

    return false;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

  }
}
