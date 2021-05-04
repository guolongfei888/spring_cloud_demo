package com.cloud.controller;

import com.common.pojo.TOrder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: guo
 * @Date: 16:53 2021/5/3
 */
@RestController
@RequestMapping("/consumer/order")
public class ConsumerController {
    // 订单服务提供者模块的 url 前缀
//    private static final String ORDER_PROVIDER_URL_PREFIX = "http://localhost:8001";

    private static final String ORDER_PROVIDER_URL_PREFIX = "http://SERVICE-ORDER";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/get/{id}")
    public TOrder getOrder(@PathVariable Long id) {
        return restTemplate.getForObject(ORDER_PROVIDER_URL_PREFIX+"/provider/order/get/" + id, TOrder.class);
    }


    @SuppressWarnings("unchecked")
    @GetMapping("/get/list")
    public List<TOrder> getOrder() {
        return restTemplate.getForObject(ORDER_PROVIDER_URL_PREFIX+"/provider/order/get/list" , List.class);
    }


}
