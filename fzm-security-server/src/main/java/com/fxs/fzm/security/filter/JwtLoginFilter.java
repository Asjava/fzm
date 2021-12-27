package com.fxs.fzm.security.filter;

import com.fxs.fzm.security.bean.Role;
import com.fxs.fzm.security.bean.WebUser;
import com.fxs.fzm.security.config.RsaKeyProperties;
import com.fxs.fzm.security.utils.JwtUtil;
import com.google.common.collect.Maps;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * Title:验证登录
 * Description:
 * Copyright: Copyright (c) 2020-09-13
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    private RsaKeyProperties rsaKeyProperties;

    /**
     * 重写登录路径地址
     * @param authenticationManager
     */
    public JwtLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/auth/login");
    }

    //10天过期时间
    private static final int ttl = 10*24*60*60*1000;

    public JwtLoginFilter(AuthenticationManager authenticationManager, RsaKeyProperties rsaKeyProperties) {
        this.authenticationManager = authenticationManager;
        this.rsaKeyProperties = rsaKeyProperties;
    }

    /**
     * 取对应的username，password交由authenticationManager做认证
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            WebUser user = new ObjectMapper().readValue(request.getInputStream(), WebUser.class);
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            return authenticationManager.authenticate(authRequest);
        } catch (IOException e) {
            try {
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                PrintWriter out = response.getWriter();
                Map<String, Object> resulMap = Maps.newHashMap();
                resulMap.put("code", HttpServletResponse.SC_UNAUTHORIZED);
                resulMap.put("msg", "用户名或密码错误");
                out.write(new ObjectMapper().writeValueAsString(resulMap));
                out.flush();
                out.close();
            } catch (IOException outEx) {
                outEx.printStackTrace();
            }
            throw new RuntimeException(e);
        }
    }

    /**
     * 验证成功后的操作
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult){
        WebUser user = new WebUser();
        user.setUserName(authResult.getName());
        user.setRoles((List<Role>)authResult.getAuthorities());
        String token = JwtUtil.generateTokenExpireInSeconds(user, rsaKeyProperties.getPrivateKey(), ttl);
        response.addHeader("Authorization", "Bearer " + token);
        try {
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            PrintWriter out = response.getWriter();
            Map<String, Object> resulMap = Maps.newHashMap();
            resulMap.put("code", HttpServletResponse.SC_OK);
            resulMap.put("msg", "认证通过");
            out.write(new ObjectMapper().writeValueAsString(resulMap));
            out.flush();
            out.close();
        } catch (Exception outEx) {
            outEx.printStackTrace();
        }
    }

}
