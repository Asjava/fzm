package com.fxs.fzm.order.controller;

import com.fxs.fzm.common.base.BaseController;
import com.fxs.fzm.common.utils.ExceptionUtil;
import com.fxs.fzm.common.utils.Page;
import com.fxs.fzm.order.bean.Order;
import com.fxs.fzm.order.service.IOrderService;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Title: 接口
 * Description:
 * Copyright: Copyright (c) 2020-09-09 10:41:51
 * Company: 北京福富软件技术股份有限公司福州分公司
 * @author: fuzm
 */
@Controller
@RequestMapping("/order")
@Slf4j
public class OrderController extends BaseController {

    @Autowired
    private IOrderService orderService;
    
    @PostMapping(value="/add")
    @ResponseBody
    public Map<String, Object> add(@RequestBody Order order) {
        Map<String, Object> resultMap = Maps.newHashMap();
        try {
            if(order == null) {
                setFailureMap(resultMap,"入参异常");
                return resultMap;
            }
            this.orderService.insert(order);
            setAddSuccessMap(resultMap);
        } catch (Exception ex) {
            log.error("执行异常:{}", ExceptionUtil.getStackTrace(ex));
            setAddFailureMap(resultMap);
        }
        return resultMap;
    }
    
    @PostMapping(value="/updateById")
    @ResponseBody
    public Map<String, Object> updateById(@RequestBody Order order) {
        Map<String, Object> resultMap = Maps.newHashMap();
        try {
            if(order == null || order.getId() == null) {
                setFailureMap(resultMap,"入参异常");
                return resultMap;
            }
            this.orderService.updateByPrimaryKeySelective(order);
            setUpdateSuccessMap(resultMap);
        } catch (Exception ex) {
            log.error("执行异常:{}", ExceptionUtil.getStackTrace(ex));
            setUpdateFailureMap(resultMap);
        }
        return resultMap;
    }
    
    @PostMapping(value="/deleteById")
    @ResponseBody
    public Map<String, Object> deleteById(@RequestBody Order order) {
        Map<String, Object> resultMap = Maps.newHashMap();
        try {
            if(order == null || order.getId() == null) {
                setFailureMap(resultMap,"入参异常");
                return resultMap;
            }
            this.orderService.deleteByPrimaryKey(order.getId());
            setDeleteSuccessMap(resultMap);
        } catch (Exception ex) {
            log.error("执行异常:{}", ExceptionUtil.getStackTrace(ex));
            setDeleteFailureMap(resultMap);
        }
        return resultMap;
    }
    
    @PostMapping(value="/queryById")
    @ResponseBody
    public Map<String, Object> queryById(@RequestBody Order order) {
        Map<String, Object> resultMap = Maps.newHashMap();
        try {
            if(order == null || order.getId() == null) {
                setFailureMap(resultMap,"入参异常");
                return resultMap;
            }
            Order resultOrder = this.orderService.selectByPrimaryKey(order.getId());
            setQuerySuccessMap(resultMap, resultOrder);
        } catch (Exception ex) {
            log.error("执行异常:{}", ExceptionUtil.getStackTrace(ex));
            setQueryFailureMap(resultMap);
        }
        return resultMap;
    }

    @PostMapping(value="/queryByParam")
    @ResponseBody
    public Map<String, Object> queryByParam(@RequestBody Map<String, Object> params) {
        Map<String, Object> resultMap = Maps.newHashMap();
        Map<String, Object> paramsMap = Maps.newHashMap();
        try {
            List<Order> orderList = this.orderService.selectByParam(paramsMap);
            setQuerySuccessMap(resultMap, orderList);
        } catch (Exception ex) {
            log.error("执行异常:{}", ExceptionUtil.getStackTrace(ex));
            setQueryFailureMap(resultMap);
        }
        return resultMap;
    }
    
    @PostMapping(value="/queryByPage")
    @ResponseBody
    public Map<String, Object> queryByPage(@RequestBody Map<String, Object> params) {
        Map<String, Object> resultMap = Maps.newHashMap();
        Map<String, Object> paramsMap = Maps.newHashMap();
        try {
            Page<Order> orderPage = this.orderService.selectPage(paramsMap);
            setQuerySuccessMap(resultMap, orderPage);
        } catch (Exception ex) {
            log.error("执行异常:{}", ExceptionUtil.getStackTrace(ex));
            setQueryFailureMap(resultMap);
        }
        return resultMap;
    }

}