package com.example.sleuthproduct.controller;

import com.example.bean.entity.Product;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @Date: 2022/2/8 10:42
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/list")
    public List<Product> listByIds(@RequestBody List<Long> ids){
        return ids.stream().map(id -> new Product(id, "test" + id, 1000L, 1000L)).collect(Collectors.toList());
    }

    @RequestMapping("/get")
    public Product get(@RequestBody Long id){
        return new Product(id, "test" + id, 1000L, 1000L);
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
