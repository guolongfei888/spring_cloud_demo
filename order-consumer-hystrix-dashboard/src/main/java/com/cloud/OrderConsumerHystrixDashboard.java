package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Auther: guo
 * @Date: 10:01 2021/5/4
 */
@SpringBootApplication
@EnableHystrixDashboard
public class OrderConsumerHystrixDashboard {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerHystrixDashboard.class, args);
    }
}
