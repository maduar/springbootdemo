package com.maduar.springbootdemo.annotation;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.condition.*;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/*
 * 识别注解
 *
 * @author maduar
 * @date 13/08/2018 5:52 PM
 * @email maduar@163.com
 *
 * */
@NoArgsConstructor
public class ApiVersionRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

//    @Value("${server.context-path}")
//    private String contextPath;

    private String contextPath = "/springbootdemo/api";

    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo info = super.getMappingForMethod(method, handlerType);
        if (info == null) {
            return null;
        }
        ApiVersion methodAnnotation = (ApiVersion) AnnotationUtils.findAnnotation(method, ApiVersion.class);
        if (methodAnnotation != null) {
            RequestCondition<?> methodCondition = getCustomMethodCondition(method);

            info = createApiVersionInfo(methodAnnotation, methodCondition).combine(info);
        } else {
            ApiVersion typeAnnotation = (ApiVersion) AnnotationUtils.findAnnotation(handlerType, ApiVersion.class);
            if (typeAnnotation != null) {
                RequestCondition<?> typeCondition = getCustomTypeCondition(handlerType);

                info = createApiVersionInfo(typeAnnotation, typeCondition).combine(info);
            }
        }

        return info;
    }

    private RequestMappingInfo createApiVersionInfo(ApiVersion annotation, RequestCondition<?> customCondition) {
        int value = annotation.value();
        String[] patterns = new String[3];

        patterns[0] = contextPath + ("/v" + value);
        patterns[1] = "/{version}";
        patterns[2] = "/**";

        return new RequestMappingInfo(
                new PatternsRequestCondition(patterns, getUrlPathHelper(), getPathMatcher(), useSuffixPatternMatch(),
                        useTrailingSlashMatch(), getFileExtensions()),
                new RequestMethodsRequestCondition(new RequestMethod[0]), new ParamsRequestCondition(new String[0]),
                new HeadersRequestCondition(new String[0]), new ConsumesRequestCondition(new String[0]),
                new ProducesRequestCondition(new String[0]), customCondition);
    }

    protected RequestCondition<ApiVesrsionCondition> getCustomTypeCondition(Class<?> handlerType) {
        ApiVersion apiVersion = (ApiVersion) AnnotationUtils.findAnnotation(handlerType, ApiVersion.class);
        return createCondition(apiVersion);
    }

    protected RequestCondition<ApiVesrsionCondition> getCustomMethodCondition(Method method) {
        ApiVersion apiVersion = (ApiVersion) AnnotationUtils.findAnnotation(method, ApiVersion.class);
        return createCondition(apiVersion);
    }

    private RequestCondition<ApiVesrsionCondition> createCondition(ApiVersion apiVersion) {
        return apiVersion == null ? null : new ApiVesrsionCondition(apiVersion.value());
    }
}
