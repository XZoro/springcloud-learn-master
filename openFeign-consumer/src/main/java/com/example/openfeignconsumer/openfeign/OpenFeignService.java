package com.example.openfeignconsumer.openfeign;

import com.example.bean.dto.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 000061382
 */
@FeignClient(value = "openFeign-provider", fallback = OpenFeignFallbackServiceImpl.class)
public interface OpenFeignService {

    @GetMapping("/openfeign/provider/order2")
    Order createOrder2();

    @GetMapping("/openfeign/provider/test/{id}")
    String get(@PathVariable("id")Integer id);

    @PostMapping("/openfeign/provider/test2")
    String test(@RequestParam("id") String arg1, @RequestParam("name") String arg2);
}
