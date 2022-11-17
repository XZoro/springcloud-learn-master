package com.example.bean.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO
 * @Date: 2022/2/8 11:09
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
public class Product implements Serializable {
    /**
     *
     */
    private Long id;

    /**
     *
     */
    private String name;

    /**
     * 数量
     */
    private Long num;

    /**
     *
     */
    private Date createTime;

    /**
     * 单价，单位分
     */
    private Long price;

    private static final long serialVersionUID = 1L;

    public Product(Long id, String name, Long num, Long price) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.price = price;
        this.createTime = new Date();
    }
}
