package com.example.oauth.server.exception;

import com.example.oauth.server.model.ResultCode;
import com.example.oauth.server.model.ResultMsg;
import com.example.oauth.server.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xzq
 * @date 2022年11月17日 18:04
 */
@Slf4j
@Component
public class OauthResourceAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        //TODO token失效提示
        ResponseUtils.result(httpServletResponse,new ResultMsg(ResultCode.TOKEN_INVALID.getCode(),ResultCode.TOKEN_INVALID.getMsg(),null));
    }
}
