package com.fxs.fzm.security.filter;

import com.fxs.fzm.security.bean.PayLoad;
import com.fxs.fzm.security.bean.WebUser;
import com.fxs.fzm.security.config.RsaKeyProperties;
import com.fxs.fzm.security.utils.JwtUtil;
import com.google.common.collect.Maps;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Title:校验token
 * Description:
 * Copyright: Copyright (c) 2020-09-13
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class JwtVerifyFilter extends BasicAuthenticationFilter {

    private RsaKeyProperties rsaKeyProperties;

    public JwtVerifyFilter(AuthenticationManager authenticationManager, RsaKeyProperties rsaKeyProperties) {
        super(authenticationManager);
        this.rsaKeyProperties = rsaKeyProperties;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            String header = request.getHeader("Authorization");
            if (header == null || !header.startsWith("Bearer ")) {
                // 如果携带错误的token，则给用户提示请登录！
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                PrintWriter out = response.getWriter();
                Map<String, Object> resulMap = Maps.newHashMap();
                resulMap.put("code", HttpServletResponse.SC_FORBIDDEN);
                resulMap.put("msg", "请登录");
                out.println(new ObjectMapper().writeValueAsString(resulMap));
                out.flush();
                out.close();
            } else {
                // 如果携带了正确格式的token要先得到token
                String token = header.replace("Bearer ", "");
                // 验证token是否正确
                PayLoad<WebUser> payLoad = JwtUtil.getInfoFromToken(token, rsaKeyProperties.getPublicKey(), WebUser.class);
                WebUser user = payLoad.getUserInfo();
                if (user != null) {
                    UsernamePasswordAuthenticationToken authResult = new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authResult);
                }
            }
        } catch (Exception e) {
            logger.info(new Exception("验证token失败，请联系管理员"));
            e.printStackTrace();
        } finally {
            chain.doFilter(request, response);
        }
    }

}
