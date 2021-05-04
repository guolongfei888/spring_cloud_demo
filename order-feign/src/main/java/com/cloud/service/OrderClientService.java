package com.cloud.service;

import com.common.pojo.TOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * feign客户端
 */
@FeignClient(value = "SERVICE-ORDER")
// 熔断   绑定一下我们定义的 hystrix 处理类：
public interface OrderClientService {

    @GetMapping("/provider/order/get/{id}")
    TOrder getOrder(@PathVariable(value = "id") Long id);

    @GetMapping("/provider/order/get/list")
    List<TOrder> getAll();
}
