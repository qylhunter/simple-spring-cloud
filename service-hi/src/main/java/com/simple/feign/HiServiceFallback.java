package com.simple.feign;

import org.springframework.stereotype.Component;

@Component
public class HiServiceFallback implements HiService {
    @Override
    public String test() {
        System.out.println("调用service-hello服务的hello接口出现错误!");
        return "look日志输出";
    }
}
