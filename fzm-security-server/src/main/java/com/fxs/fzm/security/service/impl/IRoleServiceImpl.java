package com.fxs.fzm.security.service.impl;

import com.fxs.fzm.common.annotation.ServiceProperty;
import com.fxs.fzm.common.base.IBaseDao;
import com.fxs.fzm.common.base.IBaseServiceImpl;
import com.fxs.fzm.common.cache.redis.Cache;
import com.fxs.fzm.security.bean.Role;
import com.fxs.fzm.security.dao.IRoleDao;
import com.fxs.fzm.security.service.IRoleService;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Title: 角色表service实现类
 * Description:
 * Copyright: Copyright (c) 2020-09-15 22:19:07
 * Company: 北京福富软件技术股份有限公司福州分公司
 * @author: fuzm
 */
@Component("roleService")
@ServiceProperty(remote = false)
public class IRoleServiceImpl extends IBaseServiceImpl<Role> implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Autowired
    private Cache redisCache;

    @Override
    protected IBaseDao<Role> getDao() {
        return roleDao;
    }
    
    @Override
    protected Cache getRedisCache() {
        return redisCache;
    }

    @Override
    protected TypeReference<?> getCacheTypeReference(int type) {
        if (type == 1) {
            return new TypeReference<Role>() {
            };
        } else {
            return new TypeReference<List<Role>>() {
            };
        }
    }
}