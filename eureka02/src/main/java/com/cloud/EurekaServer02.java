package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther: guo
 * @Date: 18:00 2021/5/3
 * '@EnableEurekaServer' 注解表示服务器端启动类，接受其他微服务注册进来
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer02 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer02.class, args);
    }
}
