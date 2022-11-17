package com.example.seataorder.openfeign;

import com.example.bean.dto.BaseResponseDTO;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @Date: 2022/1/27 17:36
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@Component
public class AccountFeignServiceImpl implements AccountFeignService{

    @Override
    public BaseResponseDTO<?> deduct(String userId, Long money) {
        return BaseResponseDTO.fail("90001","金额扣除失败");
    }
}
