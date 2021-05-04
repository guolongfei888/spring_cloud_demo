package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @EnableEurekaClient eureka客户端
 * @EnableFeignClients feign客户端
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderConsumerFeign {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerFeign.class, args);
    }
}
