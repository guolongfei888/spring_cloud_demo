package com.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Auther: guo
 * @Date: 16:33 2021/5/3
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TOrder {

    private Long id; // 主键id
    private String name; // 商品名称
    private BigDecimal price; // 商品价格
    private String dbSource; // 所存的数据库

}
