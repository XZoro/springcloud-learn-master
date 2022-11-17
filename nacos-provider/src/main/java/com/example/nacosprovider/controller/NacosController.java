package com.example.nacosprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @Date: 2021/12/24 16:38
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@RestController
@RequestMapping("/nacos")
public class NacosController {

    @GetMapping("/test/{id}")
    public String test(@PathVariable("id") Integer id){
        return "accept one  msg id =" + id;
    }
}
