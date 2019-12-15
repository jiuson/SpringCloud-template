package com.yipinketang.consumer.config;

import feign.RequestInterceptor;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * description: FeignConfiguration 测试feign的功能 <br>
 * date: 2019/12/15 17:11 <br>
 * author: jiuson <br>
 * version: 1.0 <br>
 */
@Configuration
public class FeignConfiguration {

    /**
     * 个性化feign的重试机制
     * @return
     */
    @Bean
    public Retryer retryer(){
        new Retryer.Default(1000L, 1000L, 3);
        return Retryer.Default.NEVER_RETRY;//从不重试
    }

    /**
     * 通过feign调用微服务时，将源请求的header和参数一并传到下一个服务
     * @return
     */
    @Bean
    public RequestInterceptor requestInterceptor(){
        return template -> {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest httpServletRequest = requestAttributes.getRequest();
            Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
            if (headerNames != null){
                while (headerNames.hasMoreElements()){
                    String name = headerNames.nextElement();
                    String value = httpServletRequest.getHeader(name);
                    template.header(name, value);
                }
            }
            Enumeration<String> bodyNames = httpServletRequest.getParameterNames();
            StringBuffer bodyValue = new StringBuffer();
            if (bodyNames != null){
                while (bodyNames.hasMoreElements()){
                    String name = bodyNames.nextElement();
                    String values = httpServletRequest.getParameter(name);
                    bodyValue.append(name).append("=").append(values).append("&");
                }
            }
            if (bodyValue.length() != 0){
                bodyValue.deleteCharAt(bodyValue.length() -1);
                template.body(bodyValue.toString());
            }
        };
    }
}
