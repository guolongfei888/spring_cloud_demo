package com.cloud.controller;

import com.cloud.service.OrderService;
import com.common.pojo.TOrder;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: guo
 * @Date: 16:20 2021/5/3
 */
@RestController
@RequestMapping("/provider/order")
@Slf4j
public class OrderProvider01Controller {

    @Resource
    private OrderService orderService;

    @Resource
    private EurekaClient eurekaClient;

    /**
     * HystrixCommond注解中的fallbackMethod指示的是：当该方法出异常时，调用processGetOrderHystrix方法
     * @param id id
     * @return 订单信息
     */
    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "processGetOrderHystrix")
    public TOrder getOrder(@PathVariable Long id) {
        TOrder order = orderService.getOrderById(id);
        if (order == null) {
            throw new RuntimeException("数据库没有对应的信息");
        }
        return order;
    }

    /**
     * 上面getOrder()方法出异常后的熔断处理方法
     * @param id
     * @return
     */
    public TOrder processGetOrderHystrix(@PathVariable Long id) {
        return new TOrder(id,"未找到该ID的结果", BigDecimal.ZERO,"No this datasource");
    }



    @GetMapping("/get/list")
    public List<TOrder> getAll() {
        return orderService.getAll();
    }


    @GetMapping("/discovery")
    public Object discovery() {
        // 获取Eureka中所有的服务节点
        List<Application> applications = eurekaClient.getApplications().getRegisteredApplications();
        if (!CollectionUtils.isEmpty(applications)) {
            for (Application application : applications) {
                // 对外暴露的服务名称
                String name = application.getName();
                // 只看订单服务信息
                if ("SERVICE-ORDER".equals(name)) {
                    // 服务有多少个实例，比如订单服务可能部署了多个，有多个订单服务注册到了eureka
                    List<InstanceInfo> instances = application.getInstances();
                    log.info("所有的订单服务:{}",instances);
                    if (!CollectionUtils.isEmpty(instances)) {
                        for (InstanceInfo info : instances) {
                            log.info("服务id:{}", info.getInstanceId());
                            log.info("服务主机:{}", info.getHostName());
                            log.info("服务端口:{}", info.getPort());
                        }
                    }
                    return instances;
                }
            }
        }
        return null;
    }


}
