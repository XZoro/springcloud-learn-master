package com.example.gatewayprovider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @Date: 2022/2/7 11:07
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hi")
    public String hello(){
        return "hi world";
    }
}
