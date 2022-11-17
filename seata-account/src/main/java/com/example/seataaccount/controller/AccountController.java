package com.example.seataaccount.controller;

import com.example.bean.dto.BaseResponseDTO;
import com.example.seataaccount.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @Date: 2022/1/27 16:19
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    AccountService accountService;

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping("/deduct")
    public BaseResponseDTO<?> deduct(@RequestParam("userId") String userId, @RequestParam("money") Long money) {
        accountService.deduct(userId, money);
        return BaseResponseDTO.success();
    }
}
