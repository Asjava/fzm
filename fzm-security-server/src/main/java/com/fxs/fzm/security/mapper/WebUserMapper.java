package com.fxs.fzm.security.mapper;

import com.fxs.fzm.common.base.BaseMapper;
import com.fxs.fzm.security.bean.WebUser;

import java.util.Map;

/**
 * Title: 人员表映射类
 * Description:
 * Copyright: Copyright (c) 2020-09-15 22:19:01
 * Company: 北京福富软件技术股份有限公司福州分公司
 * @author: fuzm
 */
public interface WebUserMapper extends BaseMapper<WebUser> {

    WebUser findByName(Map<String, Object> paramMap);
}
