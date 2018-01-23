package com.example.web.config;

import com.wekj.spring.redis.cache.config.JedisConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sunli
 * @create 2018-01-23 14:11
 */

@Configuration
@EnableConfigurationProperties(com.example.web.config.JedisConfig.class)
public class RedisConfig {

    @Autowired
    private com.example.web.config.JedisConfig myConfig;

    @Bean
    public JedisConfigBean jedisConfig() {
        JedisConfigBean jedisConfig = new JedisConfigBean();
        jedisConfig.setHost(myConfig.getHost());
        jedisConfig.setPort(myConfig.getPort());
        jedisConfig.setMaxTotal(myConfig.getMaxTotal());
        jedisConfig.setMaxIdle(myConfig.getMaxIdle());
        jedisConfig.setTimeout(myConfig.getTimeout());
        jedisConfig.setPasswd(myConfig.getPasswd());
        jedisConfig.setNamespace(myConfig.getNamespace());
        return jedisConfig;
    }
}
