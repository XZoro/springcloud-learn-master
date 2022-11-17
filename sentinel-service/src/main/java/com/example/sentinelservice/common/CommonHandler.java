package com.example.sentinelservice.common;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.example.bean.dto.BaseResponseDTO;
import com.example.bean.dto.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * TODO
 *
 * @Date: 2021/12/28 15:55
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@Slf4j
public class CommonHandler {

    public static ResponseEntity<?> handler(String orderNumber, BlockException exception){
        log.info("公共限流处理：被限流啦，异常消息：{}", JSON.toJSONString(exception));
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static BaseResponseDTO<?> handlerOrder(Order order,BlockException exception){
        log.info("订单创建被限流啦，异常消息：{}", JSON.toJSONString(exception));
        return BaseResponseDTO.fail("10001","创建订单被限流");
    }
}
