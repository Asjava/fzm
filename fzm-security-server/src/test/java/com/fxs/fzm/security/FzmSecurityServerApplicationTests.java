package com.fxs.fzm.security;

import com.fxs.fzm.common.utils.MD5Util;
import com.fxs.fzm.security.bean.Role;
import com.fxs.fzm.security.bean.WebUser;
import com.fxs.fzm.security.service.IRoleService;
import com.fxs.fzm.security.service.IWebUserService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class FzmSecurityServerApplicationTests {

    @Autowired
    IWebUserService webUserService;

    @Test
    void contextLoads() {

        webUserService.insertUser();
    }



}
