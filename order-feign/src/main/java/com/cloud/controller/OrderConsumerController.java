package com.cloud.controller;

import com.cloud.service.OrderClientService;
import com.common.pojo.TOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: guo
 * @Date: 23:09 2021/5/3
 */
@RestController
@RequestMapping("/consumer/order")
public class OrderConsumerController {

    @Resource
    private OrderClientService orderClientService;

    @GetMapping("/get/{id}")
    public TOrder getOrder(@PathVariable(value = "id") Long id) {
        return orderClientService.getOrder(id);
    }

    @GetMapping("/get/list")
    public List<TOrder> getAll() {
        return orderClientService.getAll();
    }


}
