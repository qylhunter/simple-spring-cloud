package com.simple.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * 请求校验、服务聚合
 * 过滤配置，比如身份认证、token时效等
 */
public class AccessFilter extends ZuulFilter {
    @Override
    public String filterType() {
        // 在进行Zuul过滤的时候可以设置其过滤执行的位置，那么此时有如下几种类型：
        // 1、pre：在请求发出之前执行过滤，如果要进行访问，肯定在请求前设置头信息
        // 2、route：在进行路由请求的时候被调用；
        // 3、post：在路由之后发送请求信息的时候被调用；
        // 4、error：出现错误之后进行调用
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0; // 设置优先级，数字越大优先级越低
    }

    @Override
    public boolean shouldFilter() {
        // judge filter: yes return true, else return false
        return true; // 该Filter是否要执行
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("欢迎来到zuul filter");
        // do something handle
        return null;
    }
}
