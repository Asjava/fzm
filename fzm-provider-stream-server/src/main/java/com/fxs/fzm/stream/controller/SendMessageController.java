package com.fxs.fzm.stream.controller;

import com.fxs.fzm.stream.service.IMessageProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-09
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
@Controller
@RequestMapping("/api/v1/provider")
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/send")
    @ResponseBody
    public String sendMessage() {
        return messageProvider.send();
    }
}
