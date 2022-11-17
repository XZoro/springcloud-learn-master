package com.example.sleuthorder.controller;

import com.example.bean.dto.SleuthOrder;
import com.example.bean.entity.Product;
import com.example.sleuthorder.feign.ProductFeignService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO
 *
 * @Date: 2022/2/8 11:38
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Resource
    ProductFeignService productFeignService;

    @GetMapping("/get/{id}")
    public SleuthOrder listById(@PathVariable(value = "id") Long id){
        List<Long> ids = Lists.newArrayList(1L,2L,3L,4L);
        List<Product> productList = productFeignService.listByIds(ids);
        log.info(productList.toString());
        return new SleuthOrder(id, 200000L, "test", productList);
    }

    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable(value = "id") Long id){
        Product product = productFeignService.get(id);
        log.info(product.toString());
        return product;
    }
}
