package com.example.seataorder.openfeign;

import com.example.bean.dto.BaseResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 000061382
 */
@FeignClient(value = "seata-account",fallback = AccountFeignServiceImpl.class)
public interface AccountFeignService {

    /**
     * 扣除用户金额
     * @author xzq
     * @date 2022/1/27 17:32
     * @param userId 用户id
     * @param money 金额
     * @return com.example.bean.dto.BaseResponseDTO<?>
     */
    @PostMapping("/account/deduct")
    BaseResponseDTO<?> deduct(@RequestParam("userId") String userId, @RequestParam("money") Long money);
}
