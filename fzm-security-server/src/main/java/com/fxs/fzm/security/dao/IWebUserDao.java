package com.fxs.fzm.security.dao;

import com.fxs.fzm.common.base.IBaseDao;
import com.fxs.fzm.security.bean.WebUser;

import java.util.Map;

/**
 * Title: 人员表dao接口类
 * Description:
 * Copyright: Copyright (c) 2020-09-15 22:19:01
 * Company: 北京福富软件技术股份有限公司福州分公司
 * @author: fuzm
 */
public interface IWebUserDao extends IBaseDao<WebUser> {

    WebUser findByName(Map<String, Object> name);
}