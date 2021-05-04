package com.cloud.mapper;

import com.common.pojo.TOrder;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: guo
 * @Date: 16:18 2021/5/3
 */
public interface OrderMapper {
    @Select("select * from t_order where id = #{id}")
    TOrder findById(Long id);

    @Select("select * from t_order")
    List<TOrder> findAll();
}
