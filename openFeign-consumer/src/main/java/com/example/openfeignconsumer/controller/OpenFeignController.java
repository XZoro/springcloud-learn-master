package com.example.openfeignconsumer.controller;

import com.example.bean.dto.Order;
import com.example.openfeignconsumer.openfeign.OpenFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @Date: 2021/12/27 15:09
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@RestController
@RequestMapping("/openfeign/consumer")
public class OpenFeignController {

    @Resource
    OpenFeignService openFeignService;

    @GetMapping("/order2")
    public Order createOrder2(){
        return openFeignService.createOrder2();
    }

    @GetMapping("/get/{id}")
    public String get(@PathVariable("id")Integer id){
        return openFeignService.get(id);
    }

    @GetMapping("/test/id={id}&name={name}")
    public String test(@PathVariable("id")String id, @PathVariable("name")String name){
        return openFeignService.test(id,name);
    }
}
