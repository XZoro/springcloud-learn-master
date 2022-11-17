package com.example.sleuthorder.feign;

import com.example.bean.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * TODO
 *
 * @Date: 2022/2/8 11:35
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@FeignClient(value = "sleuth-product")
public interface ProductFeignService {

    @PostMapping("/product/list")
    List<Product> listByIds(@RequestBody List<Long> ids);

    @PostMapping("/product/get")
    Product get(@RequestBody Long id);
}

