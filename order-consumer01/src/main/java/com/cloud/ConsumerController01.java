package com.cloud;

import com.cloud.config.MyRuleConfig;
import com.cloud.controller.ConsumerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Auther: guo
 * @Date: 16:57 2021/5/3
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "SERVICE-ORDER", configuration = MyRuleConfig.class)
public class ConsumerController01 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerController01.class, args);
    }
}
