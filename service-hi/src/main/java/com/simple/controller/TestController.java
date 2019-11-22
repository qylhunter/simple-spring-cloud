package com.simple.controller;

import com.simple.config.AuthProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.util.Base64;

@RestController
public class TestController {
    private final AuthProperty authProperty;

    public TestController(AuthProperty authProperty) {
        this.authProperty = authProperty;
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");

        String auth = authProperty.getUsername() + ":" + authProperty.getPassword(); // 认证的原始信息
//        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII"))); // 进行一个加密的处理
        // BasicAuthRequestInterceptor默认Charset是ISO_8859_1
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("ISO_8859_1"))); // 进行一个加密的处理
        // 在进行授权的头信息内容配置的时候加密的信息一定要与“Basic”之间有一个空格
        String authHeader = "Basic " + new String(encodedAuth);
        if (authHeader.equals(authorization)) {
            return "welcome feign hi test!";
        }
        return "auth error";
    }

}
