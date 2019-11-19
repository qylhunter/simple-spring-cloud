package com.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * 建立zuul server的方式有两种
 * 1、官方建议：在官方下载相应jar包直接运行；
 * 2、自定义，如下。
 */
@SpringBootApplication
@EnableZipkinServer
public class ZipkinStartApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinStartApplication.class, args);
    }
}
