package com.example.seataorder.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bean.dto.BaseResponseDTO;
import com.example.bean.entity.Order;
import com.example.dao.mapper.OrderMapper;
import com.example.seataorder.openfeign.AccountFeignService;
import com.example.seataorder.openfeign.StorageFeignService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.LinkedHashMap;

/**
 * TODO
 *
 * @Date: 2022/1/27 17:01
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@Service
@Slf4j
public class OrderService extends ServiceImpl<OrderMapper, Order> {

    @Resource
    OrderMapper orderMapper;
    @Resource
    AccountFeignService accountFeignService;
    @Resource
    StorageFeignService storageFeignService;


    @GlobalTransactional
    public Order create(String userId, Long productId, Long num){

        //1、扣减库存
        log.info("扣减库存开始···············");
        storageFeignService.deduct(productId, num);
        log.info("扣减库存结束···············");

        //2、扣余额
        log.info("扣减余额开始···············");
        BaseResponseDTO<?> b = storageFeignService.getInfoById(productId);
        LinkedHashMap<String, Object> data = (LinkedHashMap<String, Object>) b.getData();
        Long price = Long.parseLong(data.get("price").toString());
        accountFeignService.deduct(userId, price*num);
        log.info("扣减余额结束···············");
        int i = 1/0;

        //3、创建订单
        log.info("创建订单开始···············");
        Order order = new Order();
        order.setProductId(productId);
        order.setNum(num);
        order.setUserId(userId);
        order.setCreateTime(new Date());
        log.info("创建订单结束···············");

        orderMapper.insert(order);
        return order;
    }
}
