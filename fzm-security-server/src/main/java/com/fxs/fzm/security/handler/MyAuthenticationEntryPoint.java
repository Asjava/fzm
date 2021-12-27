package com.fxs.fzm.security.handler;

import com.alibaba.fastjson.JSON;
import com.fxs.fzm.common.base.resultMsg.AuthResultMsg;
import com.fxs.fzm.common.enums.auth.AuthResultEnum;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-17
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.getWriter().write(JSON.toJSONString(AuthResultMsg.result(AuthResultEnum.USER_NEED_AUTHORITIES,false)));
    }
}
