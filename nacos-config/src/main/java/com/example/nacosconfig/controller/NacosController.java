package com.example.nacosconfig.controller;

import com.example.nacosconfig.domain.DynamicConfigEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @Date: 2021/12/24 17:30
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@RestController
@RequestMapping("/nacos")
public class NacosController {

    @Autowired
    private DynamicConfigEntity entity;

    @GetMapping("/test/{id}")
    public String test(@PathVariable("id")Integer id){
        return "accept one msg id="+id+"----- version="+entity.getVersion();
    }
}
