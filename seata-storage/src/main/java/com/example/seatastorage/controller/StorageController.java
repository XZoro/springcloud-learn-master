package com.example.seatastorage.controller;

import com.example.bean.dto.BaseResponseDTO;
import com.example.seatastorage.service.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @Date: 2022/1/27 11:10
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Resource
    StorageService storageService;

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping("/getInfoById")
    public BaseResponseDTO<?> getInfoById(@RequestParam("id") Long id){
        return BaseResponseDTO.success(storageService.getInfoById(id));
    }

    @RequestMapping("/deduct")
    public BaseResponseDTO<?> deduct(@RequestParam("id") Long id, @RequestParam("num") Long num){
        storageService.deduct(id,num);
        return BaseResponseDTO.success();
    }
}
