package com.example.sentinelservice.controller;

import com.example.bean.dto.BaseResponseDTO;
import com.example.bean.dto.Order;
import com.example.sentinelservice.service.FlowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * test
 *
 * @Date: 2021/12/28 11:44
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@RestController
@RequestMapping("/sentinel")
public class FlowLimitController {

    @Resource
    FlowService flowService;

    @GetMapping("test")
    public String test(){
        return "接收到一条消息--------";
    }

    @GetMapping("order")
    public String order(){
        return "下单成功--------";
    }

    @GetMapping("pay")
    public String pay(){
        return "支付成功--------";
    }

    @GetMapping("/order/query")
    public String query(@RequestParam(value = "p1",required = false) String p1, @RequestParam(value = "p2",required = false)String p2){
        return flowService.query(p1,p2);
    }

    @GetMapping("/queryOrder")
    public ResponseEntity<Order> queryOrder(@RequestParam(value = "p1",required = false) String p1){
        return flowService.queryOrder(p1);
    }

    @PostMapping("/createOrder")
    public BaseResponseDTO<?> createOrder(@RequestBody Order order){
        return flowService.createOrder(order);
    }
}
