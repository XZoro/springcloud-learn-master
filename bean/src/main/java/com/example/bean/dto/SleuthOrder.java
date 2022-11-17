package com.example.bean.dto;

import com.example.bean.entity.Product;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * TODO
 *
 * @Date: 2022/2/8 11:12
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@Data
public class SleuthOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long useMoney;

    private String userId;

    private List<Product> productList;

    public SleuthOrder(Long id, Long useMoney, String userId, List<Product> productList) {
        this.id = id;
        this.useMoney = useMoney;
        this.userId = userId;
        this.productList = productList;
    }
}
