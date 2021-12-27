package com.fxs.fzm.security.service;

import com.fxs.fzm.common.base.IBaseService;
import com.fxs.fzm.security.bean.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Title: 人员表service接口类
 * Description:
 * Copyright: Copyright (c) 2020-09-15 22:19:01
 * Company: 北京福富软件技术股份有限公司福州分公司
 * @author: fuzm
 */
public interface IWebUserService extends IBaseService<WebUser>, UserDetailsService {

    void insertUser();

}