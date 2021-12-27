package com.fxs.fzm.security.service.impl;

import com.fxs.fzm.common.annotation.ServiceProperty;
import com.fxs.fzm.common.base.IBaseDao;
import com.fxs.fzm.common.base.IBaseServiceImpl;
import com.fxs.fzm.common.cache.redis.Cache;
import com.fxs.fzm.security.bean.Role;
import com.fxs.fzm.security.bean.WebUser;
import com.fxs.fzm.security.dao.IRoleDao;
import com.fxs.fzm.security.dao.IWebUserDao;
import com.fxs.fzm.security.service.IWebUserService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Title: 人员表service实现类
 * Description:
 * Copyright: Copyright (c) 2020-09-15 22:19:01
 * Company: 北京福富软件技术股份有限公司福州分公司
 * @author: fuzm
 */
@Component("webUserService")
@ServiceProperty(remote = false)
public class IWebUserServiceImpl extends IBaseServiceImpl<WebUser> implements IWebUserService {

    @Autowired
    private IWebUserDao webUserDao;

    @Autowired
    private IRoleDao roleDao;
    
    @Autowired
    private Cache redisCache;

    @Override
    protected IBaseDao<WebUser> getDao() {
        return webUserDao;
    }
    
    @Override
    protected Cache getRedisCache() {
        return redisCache;
    }

    @Override
    protected TypeReference<?> getCacheTypeReference(int type) {
        if (type == 1) {
            return new TypeReference<WebUser>() {
            };
        } else {
            return new TypeReference<List<WebUser>>() {
            };
        }
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("userName", userName);
        UserDetails userDetails = webUserDao.findByName(paramMap);
        return userDetails;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertUser() {
            List<WebUser> webUserList = Lists.newArrayList();
            WebUser webUser = new WebUser();
            webUser.setUserName("ceshi1");
            webUserList.add(webUser);
            WebUser webUser1 = new WebUser();
            webUser.setUserName("ceshi1");
            webUser.setId(1L);
            webUserList.add(webUser1);
            webUserDao.batchInsert(webUserList);

//            int i = 1/ 0;

            List<Role> roleList = Lists.newArrayList();
            Role role = new Role();
            role.setDeptId(1L);
            roleList.add(role);
            Role role2 = new Role();
            role.setDeptId(2L);
            roleList.add(role2);
            roleDao.batchInsert(roleList);
    }
}