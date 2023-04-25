package com.fzm.netty.rpc.service;

import org.springframework.stereotype.Component;

@Component("bMan")
public class BasketballMan implements Person{
    @Override
    public String say(String name) {

        return "I am " + name;
    }
}
