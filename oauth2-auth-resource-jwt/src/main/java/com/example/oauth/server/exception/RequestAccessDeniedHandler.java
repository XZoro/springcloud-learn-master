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
 * @author xzq
 * @date 2022年11月17日 9:46
 */
@Component
public class RequestAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {
        //TODO 无权限访问 根据业务自己定制提示信息
        ResponseUtils.result(response,new ResultMsg(ResultCode.NO_PERMISSION.getCode(),ResultCode.NO_PERMISSION.getMsg(),null));
    }
}
