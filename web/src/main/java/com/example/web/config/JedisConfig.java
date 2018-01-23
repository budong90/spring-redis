package com.example.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by ZhouHangqi on 2017/11/29.
 */
@Component
@ConfigurationProperties(prefix = "redis")
//@PropertySource("classpath:/im-server-web.properties")
@Data
public class JedisConfig {

    private String host;

    private Integer port;

    private Integer maxTotal;

    private Integer maxIdle;

    private Integer timeout;

    private String passwd;

    private String namespace;
}
