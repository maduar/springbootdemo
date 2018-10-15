//package com.maduar.springbootdemo.aop;
//
//import com.alibaba.fastjson.JSON;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Aspect;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
///*
// *
// * @author maduar
// * @date 11/08/2018 11:10 AM
// * @email maduar@163.com
// *
// * */
//@Aspect
//@Component
//public class WebExceptionAspect {
//
//    private static final Logger logger = LoggerFactory.getLogger(WebExceptionAspect.class);
//
//    //凡是注解了RequestMapping的方法都被拦截   @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
//    private void webPointcut() {
//    }
//
//    @AfterThrowing(pointcut = "webPointcut()", throwing = "e")
//    public void handleThrowing(Exception e) {
//        e.printStackTrace();
//        logger.error("发现异常！" + e.getMessage());
//        logger.error(JSON.toJSONString(e.getStackTrace()));
//        //这里输入友好性信息
//        writeContent("出现异常");
//    }
//
//    /**
//     * 将内容输出到浏览器
//     *
//     * @param content
//     *            输出内容
//     */
//    private void writeContent(String content) {
//        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
//                .getResponse();
//        response.reset();
//        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Content-Type", "text/plain;charset=UTF-8");
//        response.setHeader("icop-content-type", "exception");
//        PrintWriter writer = null;
//        try {
//            writer = response.getWriter();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        writer.print(content);
//        writer.flush();
//        writer.close();
//    }
//}
