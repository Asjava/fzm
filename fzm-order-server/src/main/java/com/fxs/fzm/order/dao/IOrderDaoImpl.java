package com.fxs.fzm.order.dao;

import com.fxs.fzm.common.annotation.RepositoryProperty;
import com.fxs.fzm.common.base.BaseMapper;
import com.fxs.fzm.common.base.IBaseDaoImpl;
import com.fxs.fzm.order.bean.Order;
import com.fxs.fzm.order.mapper.OrderMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Title: dao实现类
 * Description:
 * Copyright: Copyright (c) 2020-09-09 10:41:51
 * Company: 北京福富软件技术股份有限公司福州分公司
 * @author: fuzm
 */
@Component("orderDao")
@RepositoryProperty(namespace = "tbl_fzm_order")
public class IOrderDaoImpl extends IBaseDaoImpl<Order> implements IOrderDao {

    @Resource
    OrderMapper orderMapper;

    @Override
    protected BaseMapper<Order> getMapper() {
        return orderMapper;
    }

}