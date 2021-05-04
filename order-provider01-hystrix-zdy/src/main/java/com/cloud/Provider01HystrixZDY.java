package com.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: guo
 * @Date: 16:21 2021/5/3
 * "@EnableEurekaClient" 服务启动后会自动注册到eureka服务中心
 * `@EnableCircuitBreaker` hystrix
 */
@SpringBootApplication
@MapperScan("com.cloud.mapper")
@EnableEurekaClient
@EnableCircuitBreaker
public class Provider01HystrixZDY {
    public static void main(String[] args) {
        SpringApplication.run(Provider01HystrixZDY.class, args);
    }
}
