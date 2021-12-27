package com.fxs.fzm.security.dao;

import com.fxs.fzm.common.annotation.RepositoryProperty;
import com.fxs.fzm.common.base.BaseMapper;
import com.fxs.fzm.common.base.IBaseDaoImpl;
import com.fxs.fzm.security.bean.Role;
import com.fxs.fzm.security.mapper.RoleMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Title: 角色表dao实现类
 * Description:
 * Copyright: Copyright (c) 2020-09-15 22:19:07
 * Company: 北京福富软件技术股份有限公司福州分公司
 * @author: fuzm
 */
@Component("roleDao")
@RepositoryProperty(namespace = "tbl_cms_role")
public class IRoleDaoImpl extends IBaseDaoImpl<Role> implements IRoleDao {

    @Resource
    RoleMapper roleMapper;

    @Override
    protected BaseMapper<Role> getMapper() {
        return roleMapper;
    }

}