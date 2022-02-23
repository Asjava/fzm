package com.fzm.zookeeper.restful.controller;

import com.fzm.zookeeper.restful.annotation.DollarToCentFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomFormatterController {

    @RequestMapping("/custom/formatter")
    public String formatter(@DollarToCentFormat Long cent) {
        return cent.toString();
    }
}
