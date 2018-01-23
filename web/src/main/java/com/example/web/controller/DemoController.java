package com.example.web.controller;

import com.alibaba.fastjson.JSON;
import com.example.web.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author sunli
 * @create 2018-01-23 15:59
 */

@RestController
@RequestMapping(value = "/demo")
public class DemoController {

    @Autowired
    DemoService demoService;

    @RequestMapping(value = "hello")
    public String hello() {
        Map<String, String> properties = demoService.getProperties();
        String str = JSON.toJSONString(properties);
        return str;
    }

    public String world() {

        return "hello world";
    }
}
