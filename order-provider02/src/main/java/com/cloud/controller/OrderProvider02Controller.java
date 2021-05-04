package com.cloud.controller;

import com.cloud.service.OrderService;
import com.common.pojo.TOrder;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: guo
 * @Date: 16:20 2021/5/3
 */
@RestController
@RequestMapping("/provider/order")
@Slf4j
public class OrderProvider02Controller {

    @Resource
    private OrderService orderService;

    @Resource
    private EurekaClient eurekaClient;

    @GetMapping("/get/{id}")
    public TOrder getOrder(@PathVariable Long id) {
        return orderService.getOrderById(id);
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
