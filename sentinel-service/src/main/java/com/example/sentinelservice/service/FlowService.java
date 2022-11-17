package com.example.sentinelservice.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.example.bean.dto.BaseResponseDTO;
import com.example.bean.dto.Order;
import com.example.sentinelservice.common.CommonHandler;
import com.example.sentinelservice.common.FallbackHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO
 *
 * @Date: 2021/12/28 15:15
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@Service
@Slf4j
public class FlowService {


    @SentinelResource(value = "OrderQuery", blockHandler = "handleQuery")
    public String query(String p1,String p2){
        log.info("查询商品，p1: {}, p2: {}", p1,p2);
        return "查询商品：success";
    }

    public String handleQuery(@RequestParam(value = "p1",required = false)String p1, @RequestParam(value = "p2",required = false)String p2, BlockException exception){
        log.info("查询商品，p1: {}, p2: {}", p1,p2);
        return "查询商品：熔断了..............";
    }

    @SentinelResource(value = "QueryOrder", blockHandlerClass = CommonHandler.class,blockHandler = "handler")
    public ResponseEntity<Order> queryOrder(String orderNumber){
        Order order = new Order();
        order.setId(1L);
        order.setOrderNumber(orderNumber);
        order.setRemark("test");
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    public ResponseEntity<Order> handle(String orderNumber, BlockException exception){
        log.info("被限流啦，异常消息：{}", JSON.toJSONString(exception));
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @SentinelResource(value = "createOrder", fallbackClass = FallbackHandler.class, fallback = "fallbackHandler",
    blockHandlerClass = CommonHandler.class, blockHandler = "handlerOrder")
    public BaseResponseDTO<?> createOrder(Order order){
        log.info("订单创建成功：{}", JSON.toJSONString(order));
        System.out.println(1/0);
        return BaseResponseDTO.builder()
                .code("200")
                .message("订单创建成功")
                .data(order)
                .build();
    }
}
