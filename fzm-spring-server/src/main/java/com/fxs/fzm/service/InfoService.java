package com.fxs.fzm.service;

import com.fxs.fzm.enums.Propagation;
import com.fxs.fzm.annotion.MyTransational;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    @MyTransational(propagation = Propagation.REQUIREDNEW)
    public void updateInfo(){
        System.out.println("更新Info 成功");
    }

    @MyTransational(propagation = Propagation.REQUIRED)
    public void updateInfo2(){
        System.out.println("更新Info2 成功");
    }
}
