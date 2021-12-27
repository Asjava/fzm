package com.fxs.fzm.security.handler;

import com.alibaba.fastjson.JSON;
import com.fxs.fzm.common.base.resultMsg.AuthResultMsg;
import com.fxs.fzm.common.enums.auth.AuthResultEnum;
import com.fxs.fzm.security.bean.WebUser;
import com.fxs.fzm.security.config.RsaKeyProperties;
import com.fxs.fzm.security.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
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
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private RsaKeyProperties rsaKeyProperties;

    //10天过期时间
    private static final int ttl = 10*24*60*60*1000;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {

    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        WebUser webUser = (WebUser) authentication.getPrincipal();

        String token = JwtUtil.generateTokenExpireInSeconds(webUser, rsaKeyProperties.getPrivateKey(), ttl);

        response.getWriter().write(JSON.toJSONString(AuthResultMsg.result(AuthResultEnum.USER_LOGIN_SUCCESS, token, true)));
    }
}
