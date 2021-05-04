package com.cloud.config;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 微服务都是以 HTTP 接口的形式暴露自身服务的，因此在调用远程服务时就必须使用 HTTP 客户端。
 * Spring Boot 中使用的是 RestTemplate，
 * 首先，我们写一个配置类，将 RestTemplate 作为一个 Bean 交给 Spring 来管理。
 */
@Configuration
public class RestTemplateConfig {

    /**
     * @LoadBalanced  注解表示使用Ribbon实现客户端负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /** 默认随机
     * RoundRibbonRule：轮询。人人有份，一个个来！
     * RandomRule：随机。拼人品了！
     * AvailabilityFilteringRule：先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，以及并发连接数超过阈值的服务，剩下的服务，使用轮询策略。
     * WeightedResponseTimeRule：根据平均响应时间计算所有服务的权重，响应越快的服务权重越高，越容易被选中。一开始启动时，统计信息不足的情况下，使用轮询。
     * RetryRule：先轮询，如果获取失败则在指定时间内重试，重新轮询可用的服务。
     * BestAvailableRule：先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务。
     * ZoneAvoidanceRule：复合判断 server 所在区域的性能和 server 的可用性选择服务器
     * @return
     */
//    @Bean
//    public IRule myRule() {
//        // 指定重试策略: 随机
//        return new RandomRule();
//    }
}
