package com.cloud.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义规则
 */
@Configuration
public class MyRuleConfig {

    @Bean
    public IRule myselfRule() {
        // 指定策略：我们自定义的策略
        return new CustomRule();
    }
}
