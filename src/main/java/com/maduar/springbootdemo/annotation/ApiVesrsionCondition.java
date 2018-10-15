package com.maduar.springbootdemo.annotation;

import org.apache.catalina.connector.RequestFacade;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 *
 * @author maduar
 * @date 13/08/2018 5:52 PM
 * @email maduar@163.com
 *
 * */
public class ApiVesrsionCondition implements RequestCondition<ApiVesrsionCondition> {

    // 路径中版本的前缀， 这里用 /v[1-9]/的形式
    private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile("v(\\d+)");

    private int _apiVersion;

    public int getApiVersion() {
        return this._apiVersion;
    }

    public ApiVesrsionCondition(int apiVersion) {
        this._apiVersion = apiVersion;
    }

    public ApiVesrsionCondition combine(ApiVesrsionCondition other) {
        // 采用最后定义优先原则，则方法上的定义覆盖类上面的定义
        return new ApiVesrsionCondition(other.getApiVersion());
    }

    public ApiVesrsionCondition getMatchingCondition(HttpServletRequest request) {
        String dispatcherPath = request.getRequestURI().split("/")[3];
        Matcher m = VERSION_PREFIX_PATTERN.matcher(dispatcherPath);
        if (m.find()) {
            Integer version = Integer.valueOf(m.group(1));
            if (version < this._apiVersion) // 如果请求的版本号小于配置版本号，则不满足
                return null;
        }
        return this;
    }

    public int compareTo(ApiVesrsionCondition other, HttpServletRequest request) {
        // 优先匹配最新的版本号
        int i = other.getApiVersion() - this._apiVersion;
        if (i == 0)
            return 0;
        else
            return i > 0 ? 1 : -1;
    }

}
