package com.fxs.fzm.security.service;

import org.springframework.security.core.Authentication;
import javax.servlet.http.HttpServletRequest;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-15
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public interface RbacService {
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
