package com.wx.boot.shiro;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 获取配置文件redis配置信息
 */
@Component
@ConfigurationProperties(prefix ="spring.redis") //获取配置文件前缀，属性表示配置文件后缀
@Getter
@Setter
public class RedisBean {

    //地址
    private String host;

    //端口
    private int port;

    //连接时间
    private int timeout;

    //缓存过期时间
    private int expire;

    //密码
    private String password;

}
