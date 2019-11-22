package com.simple.controller;

import com.simple.config.AuthProperty;
import com.simple.feign.HiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.util.Base64;


@RestController
public class HiController {

    private final HiService hiService;
    private final AuthProperty authProperty;

    public HiController(HiService hiService, AuthProperty authProperty) {
        this.hiService = hiService;
        this.authProperty = authProperty;
    }

    @RequestMapping(value = "hi", method = {RequestMethod.GET, RequestMethod.POST})
    public String hi(HttpServletRequest request) {
//        String authorization = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
//                .getRequest().getHeader("Authorization");
        String authorization = request.getHeader("Authorization");

        String auth = authProperty.getUsername() + ":" + authProperty.getPassword(); // 认证的原始信息
//        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII"))); // 进行一个加密的处理
        // BasicAuthRequestInterceptor默认Charset是ISO_8859_1
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("ISO_8859_1"))); // 进行一个加密的处理
        // 在进行授权的头信息内容配置的时候加密的信息一定要与“Basic”之间有一个空格
        String authHeader = "Basic " + new String(encodedAuth);

        if (authorization.equals(authHeader)) {
            return hiService.test();
        }
        return "auth error!";
    }
}
