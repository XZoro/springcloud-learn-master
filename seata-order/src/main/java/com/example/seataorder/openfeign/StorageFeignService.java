package com.example.seataorder.openfeign;

import com.example.bean.dto.BaseResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO
 *
 * @Date: 2022/1/27 17:30
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@FeignClient(value = "seata-storage", fallback = StorageFeignServiceImpl.class)
public interface StorageFeignService {

    /**
     * 扣除库存
     * @author xzq
     * @date 2022/1/27 17:32
     * @param id 库存id
     * @param num 数量
     * @return com.example.bean.dto.BaseResponseDTO<?>
     */
    @PostMapping("/storage/deduct")
    BaseResponseDTO<?> deduct(@RequestParam("id") Long id, @RequestParam("num") Long num);

    @PostMapping("/storage/getInfoById")
    BaseResponseDTO<?> getInfoById(@RequestParam("id") Long id);
}
