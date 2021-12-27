package com.fxs.fzmnacosconfigserver.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fxs.fzmnacosconfigserver.handler.GlobleBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-06
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
@Controller
@RequestMapping("/api/v1/flow")
@Slf4j
public class FlowFallBackController {

    @GetMapping("/testFallBack/{id}")
    @ResponseBody
    @SentinelResource(value = "testFallBack", fallback = "testServiceFallBack",  blockHandlerClass = GlobleBlockHandler.class, blockHandler = "testGlobleBlock")
    public String testFallBack(@PathVariable("id") int id) throws Exception {
        if (id == 4) {
            throw new IllegalAccessException("非法参数");
        } else if (id == 0){
            throw new NullPointerException("参数为空异常");
        }
        return "测试服务降级及持久化";
    }

    /**
     * 测试业务服务降级
     * @param e
     * @return
     */
    public String testServiceFallBack(int id, Throwable e){
        return "测试服务降级testServiceFallBack";
    }


}
