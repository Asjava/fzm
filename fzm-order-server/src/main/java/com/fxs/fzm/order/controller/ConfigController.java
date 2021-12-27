package com.fxs.fzm.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-05
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
@Controller
@RequestMapping("/api/v1/config")
@RefreshScope
public class ConfigController {

    @Value("${config.info:fzm}")
    private String configInfo;

    @GetMapping(value = "/info")
    @ResponseBody
    public Map<String, Object> getConfigInfo() {
        Map<String, Object> resultMap = new HashMap();
        resultMap.put("msg", configInfo);
        return resultMap;
    }

    @PostMapping(value = "/info1")
    @ResponseBody
    public Map<String, Object> getConfigInfo1() {
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String, Object> resultMap = new HashMap();
        resultMap.put("msg", configInfo + "1");
        return resultMap;
    }
}
