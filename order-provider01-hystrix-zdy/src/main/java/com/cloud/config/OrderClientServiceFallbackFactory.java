package com.cloud.config;

import com.cloud.service.OrderClientService;
import com.common.pojo.TOrder;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * 统一处理熔断
 *  * OrderClientService是Feign接口，所有访问都会走feign接口
 */
@Component
public class OrderClientServiceFallbackFactory implements FallbackFactory<OrderClientService> {

    @Override
    public OrderClientService create(Throwable throwable) {
        return new OrderClientService() {

            /**
             * 当订单服务的getOrder()方法出异常后的熔断处理方法
             * @param id id
             * @return 返回信息
             */
            @Override
            public TOrder getOrder(Long id) {
                return new TOrder(id,"未找到该ID的结果", BigDecimal.ZERO, "No this datasource");
            }

            @Override
            public List<TOrder> getAll() {
                return null;
            }
        };
    }
}
