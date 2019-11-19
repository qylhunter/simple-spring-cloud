package com.simple.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service-hi", fallback = HelloServiceFallback.class)
public interface HelloService {
    @RequestMapping(value = "test", method = RequestMethod.GET)
    String test();
}
