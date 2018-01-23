package com.example.web.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author sunli
 * @create 2018-01-23 15:59
 */

@Service
public class DemoService {

    @Cacheable(value = "getProperties#${portrait.config.cache}")
    public Map<String, String> getProperties() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>查询数据库。。。");
        Map<String, String> result = new HashMap<>();
        Properties properties = System.getProperties();
        for (Object o : properties.keySet()) {
            Object v = properties.get(o);
            result.put(o.toString(), v.toString());
        }
        return result;
    }
}
