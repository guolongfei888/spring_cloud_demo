package com.cloud.service;

import com.cloud.mapper.OrderMapper;
import com.common.pojo.TOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: guo
 * @Date: 16:25 2021/5/3
 */
@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public TOrder getOrderById(Long id) {
        return orderMapper.findById(id);
    }

    public List<TOrder> getAll() {
        return orderMapper.findAll();
    }
}
