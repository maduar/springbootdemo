package com.maduar.springbootdemo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse, Object o) throws Exception {

        String uri = httpServletRequest.getRequestURI();
        logger.info("uri: " + uri);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView)
        throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
