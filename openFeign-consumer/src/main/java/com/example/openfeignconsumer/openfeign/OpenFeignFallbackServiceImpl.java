package com.example.openfeignconsumer.openfeign;

import com.example.bean.dto.Order;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @Date: 2021/12/27 16:54
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@Component
public class OpenFeignFallbackServiceImpl implements OpenFeignService{

    @Override
    public Order createOrder2() {
        return null;
    }

    @Override
    public String get(Integer id) {
        return "get降级测试--------";
    }

    @Override
    public String test(String arg1, String arg2) {
        return "test降级测试--------";
    }
}
