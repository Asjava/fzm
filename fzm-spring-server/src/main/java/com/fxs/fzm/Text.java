package com.fxs.fzm;

import com.fxs.fzm.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Text {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TransactionBeans.class);
        UserService userService = context.getBean(UserService.class);
//        userService.updateUser();
        // requestNew与request组合
        userService.updateUser2();
        // requestNew与request组合
        userService.updateUser4();
        context.close();
    }
}
