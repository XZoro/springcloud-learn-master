package com.example.sentinelservice.common;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO
 *
 * @Date: 2021/12/28 17:12
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@Component
public class RequestOrigin implements RequestOriginParser {

    @Override
    public String parseOrigin(HttpServletRequest request) {
        return request.getRemoteAddr();
    }
}
