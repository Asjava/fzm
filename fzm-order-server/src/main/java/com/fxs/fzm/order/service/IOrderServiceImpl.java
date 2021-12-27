package com.fxs.fzm.order.service;

import com.fxs.fzm.common.annotation.ServiceProperty;
import com.fxs.fzm.common.base.IBaseDao;
import com.fxs.fzm.common.base.IBaseServiceImpl;
import com.fxs.fzm.common.cache.redis.Cache;
import com.fxs.fzm.order.bean.Order;
import com.fxs.fzm.order.dao.IOrderDao;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Title: service实现类
 * Description:
 * Copyright: Copyright (c) 2020-09-09 10:41:51
 * Company: 北京福富软件技术股份有限公司福州分公司
 * @author: fuzm
 */
@Component("orderService")
@ServiceProperty(remote = false)
public class IOrderServiceImpl extends IBaseServiceImpl<Order> implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    @Resource
    private Cache redisCache;

    @Override
    protected IBaseDao<Order> getDao() {
        return orderDao;
    }

    @Override
    protected Cache getRedisCache() {
        return redisCache;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    protected TypeReference<?> getCacheTypeReference(int type) {
        if (type == 1) {
            return new TypeReference<Order>() {
            };
        } else {
            return new TypeReference<List<Order>>() {
            };
        }
    }
}