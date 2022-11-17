package com.example.seataorder.openfeign;

import com.example.bean.dto.BaseResponseDTO;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @Date: 2022/1/27 17:37
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@Component
public class StorageFeignServiceImpl implements StorageFeignService{
    @Override
    public BaseResponseDTO<?> deduct(Long id, Long num) {
        return BaseResponseDTO.fail("90001", "扣减库存失败");
    }

    @Override
    public BaseResponseDTO<?> getInfoById(Long id) {
        return BaseResponseDTO.fail("90001", "获取商品信息失败");
    }
}
