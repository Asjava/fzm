package com.fxs.fzm.security.dao;

import com.fxs.fzm.common.annotation.RepositoryProperty;
import com.fxs.fzm.common.base.BaseMapper;
import com.fxs.fzm.common.base.IBaseDaoImpl;
import com.fxs.fzm.security.bean.WebUser;
import com.fxs.fzm.security.mapper.WebUserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Title: 人员表dao实现类
 * Description:
 * Copyright: Copyright (c) 2020-09-15 22:19:01
 * Company: 北京福富软件技术股份有限公司福州分公司
 * @author: fuzm
 */
@Component("webUserDao")
@RepositoryProperty(namespace = "tbl_cms_web_user")
public class IWebUserDaoImpl extends IBaseDaoImpl<WebUser> implements IWebUserDao {

    @Resource
    WebUserMapper webUserMapper;

    @Override
    protected BaseMapper<WebUser> getMapper() {
        return webUserMapper;
    }

    /**
     * 根据用户名称查找对象
     * @param paramMap
     * @return
     */
    @Override
    public WebUser findByName(Map<String, Object> paramMap) {
        return webUserMapper.findByName(paramMap);
    }

}