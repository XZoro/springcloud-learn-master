package com.example.openfeignprovider.controller;

import com.example.bean.dto.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

/**
 * TODO
 *
 * @Date: 2021/12/27 15:26
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@RestController
@RequestMapping("/openfeign/provider")
public class OpenFeignProviderController {

    @GetMapping("/order2")
    public Order createOrder2(){
        Order order = new Order();
        order.setId(1L);
        order.setOrderNumber("01");
        order.setRemark("test");
        return order;
    }

    @GetMapping("/test/{id}")
    public String test(@PathVariable("id")Integer id){
        return "accept one msg id="+id;
    }

    @PostMapping("/test2")
    public String test2(String id,String name) throws InterruptedException {
        //Thread.sleep(3000);
        int i = 1/0;
        return MessageFormat.format("accept on msg id={0}，name= {1}",id,name);
    }

}
