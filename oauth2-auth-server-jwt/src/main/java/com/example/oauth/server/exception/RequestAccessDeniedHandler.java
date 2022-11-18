package com.example.oauth.server.exception;

import com.example.oauth.server.model.ResultCode;
import com.example.oauth.server.model.ResultMsg;
import com.example.oauth.server.utils.ResponseUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 当认证后的用户访问受保护的资源时，权限不够，则会进入这个处理器
 * @author xzq
 * @date 2022年11月17日 9:46
 */
@Component
public class RequestAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException {
        ResponseUtils.result(httpServletResponse,new ResultMsg(ResultCode.NO_PERMISSION.getCode(),ResultCode.NO_PERMISSION.getMsg(),null));
    }
}
