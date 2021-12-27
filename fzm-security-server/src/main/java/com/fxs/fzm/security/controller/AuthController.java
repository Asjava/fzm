package com.fxs.fzm.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-09
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
@Controller
@RequestMapping("/api/v1/security")
public class AuthController {

    @GetMapping("/auth")
    @ResponseBody
    public String auth() {
        return "success";
    }
}
