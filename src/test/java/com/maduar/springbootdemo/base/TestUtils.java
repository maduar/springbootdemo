package com.maduar.springbootdemo.base;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/*
 *
 * @author maduar
 * @date 31/07/2018 4:03 PM
 * @email maduar@163.com
 *
 * */
@Component
public class TestUtils {

    public <T> HttpEntity<String> createFormEntity(@NotNull T t) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());


        String jsonObj = JSON.toJSONString(t);
        HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj, headers);
        return formEntity;

    }
}
