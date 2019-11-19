package com.simple.controller;

import com.simple.feign.HiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HiController {

    private final HiService hiService;

    public HiController(HiService hiService) {
        this.hiService = hiService;
    }

    @RequestMapping(value = "hi", method = {RequestMethod.GET, RequestMethod.POST})
    public String hi() {
        return hiService.test();
    }
}
