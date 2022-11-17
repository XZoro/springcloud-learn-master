package com.example.sentinelservice.common;

import com.example.bean.dto.BaseResponseDTO;
import com.example.bean.dto.Order;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @Date: 2021/12/28 16:39
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@Slf4j
public class FallbackHandler {

    public static BaseResponseDTO<?> defaultFallbackHandler(Throwable ex){
        log.error("进入了默认的降级兜底方法，业务处理出现了运行时异常：{}", ex.getMessage());
        return BaseResponseDTO.fail("1001","创建订单失败，出现异常了......");
    }


    public static BaseResponseDTO<?> fallbackHandler(Order order,Throwable ex){
        log.error("进入了公共的降级兜底方法，业务处理出现了运行时异常：{}", ex.getMessage());
        return BaseResponseDTO.fail("1001","创建订单失败，出现异常了......");
    }
}
