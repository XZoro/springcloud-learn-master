package com.example.oauth.server.exception;

import com.example.oauth.server.model.ResultCode;
import com.example.oauth.server.model.ResultMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.UnsupportedGrantTypeException;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;

/**
 * 自定义异常翻译器，针对用户名、密码异常，授权类型不支持的异常进行处理
 * @author xzq
 * @date 2022年11月17日 9:46
 */
@SuppressWarnings("ALL")
public class OauthServerWebResponseExceptionTranslator implements WebResponseExceptionTranslator {

    /**
     * 业务处理方法，重写这个方法返回客户端信息
     */
    @Override
    public ResponseEntity<ResultMsg> translate(Exception e){
        ResultMsg resultMsg = doTranslateHandler(e);
        return new ResponseEntity<>(resultMsg, HttpStatus.UNAUTHORIZED);
    }

    private ResultMsg doTranslateHandler(Exception e){
        //初始值，系统错误
        ResultCode resultCode = ResultCode.UNAUTHORIZED;
        //判断异常，不支持的认证方式
        if (e instanceof UnsupportedGrantTypeException){
            resultCode = ResultCode.UNSUPPORTED_GRANT_TYPE;
        } else if (e instanceof InvalidGrantException) {
            resultCode = ResultCode.UNSUPPORTED_GRANT_TYPE;
        }
        return new ResultMsg(resultCode.getCode(), resultCode.getMsg(), null);
    }
}
