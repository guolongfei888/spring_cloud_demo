package com.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: guo
 * @Date: 16:21 2021/5/3
 * "@EnableEurekaClient" 服务启动后会自动注册到eureka服务中心
 */
@SpringBootApplication
@MapperScan("com.cloud.mapper")
@EnableEurekaClient
public class Provider03Application {
    public static void main(String[] args) {
        SpringApplication.run(Provider03Application.class, args);
    }
}
