package com.example.seataorder.controller;

import com.example.bean.dto.BaseResponseDTO;
import com.example.bean.entity.Order;
import com.example.seataorder.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @Date: 2022/1/27 17:03
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    OrderService orderService;

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping("/create")
    public BaseResponseDTO<?> create(@RequestParam("userId") String userId, @RequestParam("productId") Long productId, @RequestParam("num") Long num){
        Order order = orderService.create(userId, productId, num);
        return BaseResponseDTO.success(order);
    }
}
