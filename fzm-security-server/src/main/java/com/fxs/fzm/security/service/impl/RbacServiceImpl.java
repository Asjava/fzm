package com.fxs.fzm.security.service.impl;

import com.fxs.fzm.security.service.RbacService;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.security.Permission;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-15
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
@Slf4j
public class RbacServiceImpl implements RbacService {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        log.info("进入hasPermission方法，url " + request.getRequestURI());
        Object principal = authentication.getPrincipal();

        boolean hasPermission = false;
        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();

            // 根据username，读取用户所拥有的所有权限
            Set<String> urls = Sets.newHashSet();
            urls.add("/user");
            for (String url : urls) {
                if (antPathMatcher.match(url, request.getRequestURI())) {
                    hasPermission = true;
                    break;
                }
            }
            return hasPermission;
        }

        return false;
    }
}
