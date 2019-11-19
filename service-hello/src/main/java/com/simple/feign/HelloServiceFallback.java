package com.simple.feign;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String test() {
        System.out.println("调用service-hi服务的hi接口出现错误!");
        return "look日志输出";
    }
}
