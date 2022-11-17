package com.example.nacosconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-provider}")
    private String serviceUrl;

    @GetMapping("/test/{id}")
    public ResponseEntity<String> test(@PathVariable("id") Integer id){
        return restTemplate.getForEntity(serviceUrl+"/nacos/test/"+id, String.class);
    }

    @GetMapping("/test1/{id}")
    public String test1(@PathVariable("id") Integer id){
        return "accept one  msg id =" + id;
    }
}
