package com.fxs.fzm.service;

import com.fxs.fzm.enums.Propagation;
import com.fxs.fzm.annotion.MyTransational;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private InfoService infoService;

    @MyTransational
    public void updateUser(){
        infoService.updateInfo();
        System.out.println("updateUser 成功");
    }

    @MyTransational(propagation = Propagation.REQUIREDNEW)
    public void updateUser2(){
        infoService.updateInfo();
        System.out.println("updateUser2 成功");
    }

    @MyTransational(propagation = Propagation.REQUIREDNEW)
    public void updateUser4(){
        infoService.updateInfo2();
        System.out.println("updateUser4 成功");
    }

    public void updateUser3(){
        throw new RuntimeException("更新用户失败");
    }
}
