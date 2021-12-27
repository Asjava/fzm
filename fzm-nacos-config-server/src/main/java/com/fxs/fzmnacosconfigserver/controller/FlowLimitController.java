package com.fxs.fzmnacosconfigserver.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
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
@RequestMapping("/api/v1/flowlimit")
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    @ResponseBody
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    @ResponseBody
    public String testB() {
        log.info(Thread.currentThread().getName()  + "\t" + "...testB");
//        try {
//            Thread.sleep(800);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "------testB";
    }

    @GetMapping("/testD")
    @ResponseBody
    public String testD() {
        log.info(Thread.currentThread().getName()  + "\t" + "...testD");
        int age = 10/0;
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "------testD";
    }

    @GetMapping("/testE")
    @ResponseBody
    public String testE() {
        log.info(Thread.currentThread().getName()  + "\t" + "...testE");
        int age = 10/0;
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "------testE";
    }

    @GetMapping("/testHotKey")
    @ResponseBody
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                                          @RequestParam(value = "p2", required = false) String p2)
    {
        log.info(Thread.currentThread().getName() + "\t" + "...testE");
        return "------testHotKey";
    }
    public String deal_testHotKey (String p1, String p2, BlockException exception) {
        return "------deal_testHotKey";
    }
}
