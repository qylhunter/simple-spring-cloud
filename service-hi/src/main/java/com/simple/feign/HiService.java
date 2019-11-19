package com.simple.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service-hello", fallback = HiServiceFallback.class)
public interface HiService {
    @RequestMapping(value = "test", method = RequestMethod.GET)
    String test();
}
