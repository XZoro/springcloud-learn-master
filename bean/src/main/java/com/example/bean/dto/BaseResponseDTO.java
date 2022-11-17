package com.example.bean.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * TODO
 *
 * @Date: 2021/12/28 16:27
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@Builder
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class BaseResponseDTO<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private Boolean success;
    private String message;
    T data;

    public static <T> BaseResponseDTO<T> success(T data) {
        return BaseResponseDTO.<T>builder()
                .code("0")
                .success(true)
                .message("成功")
                .data(data)
                .build();
    }

    public static <T> BaseResponseDTO<T> fail(String code,String message,T data) {
        return BaseResponseDTO.<T>builder()
                .code(code)
                .success(false)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> BaseResponseDTO<T> fail(String code,String message) {
        return BaseResponseDTO.<T>builder()
                .code(code)
                .success(false)
                .message(message)
                .data(null)
                .build();
    }

    public static <T> BaseResponseDTO<T> fail(String code) {
        return BaseResponseDTO.<T>builder()
                .code(code)
                .build();
    }

    /**
     * 请求成功，无数据实体返回
     */
    public static <T> BaseResponseDTO<T> success() {
        return BaseResponseDTO.<T>builder()
                .code("0")
                .success(true)
                .message("成功")
                .build();
    }
}
