package com.example.cloudgateway.exception;

import com.example.bean.dto.BaseResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 用于网关的全局异常处理
 * @Order(-1)：优先级一定要比ResponseStatusExceptionHandler低
 * @Date: 2022/2/7 16:12
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@Slf4j
@Order(-1)
@Component
@RequiredArgsConstructor
public class GlobalErrorExceptionHandler implements ErrorWebExceptionHandler {

    private final ObjectMapper objectMapper;

    @SuppressWarnings({"rawtypes", "unchecked", "NullableProblems"})
    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex){
        ServerHttpResponse response = exchange.getResponse();
        if (response.isCommitted()){
            return Mono.error(ex);
        }

        //JOSN格式返回
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        if (ex instanceof ResponseStatusException){
            response.setStatusCode(((ResponseStatusException) ex).getStatus());
        }

        return response.writeWith(Mono.fromSupplier(()->{
            DataBufferFactory bufferFactory = response.bufferFactory();
            try {
                //返回响应结果，根据业务需求编写
                BaseResponseDTO<?> baseResponseDTO = new BaseResponseDTO<>();
                baseResponseDTO.setCode("500");
                baseResponseDTO.setMessage(ex.getMessage());

                return bufferFactory.wrap(objectMapper.writeValueAsBytes(baseResponseDTO));
            } catch (JsonProcessingException e) {
                log.error("Error writing response", ex);
                return bufferFactory.wrap(new byte[0]);
            }
        }));
    }
}
