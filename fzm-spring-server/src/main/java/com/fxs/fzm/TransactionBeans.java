package com.fxs.fzm;

import com.fxs.fzm.annotion.EnableMyTransational;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * EnableAspectJAutoProxy 默认为proxyTargetClass = false，spring会根据情况使用jdk代理还是cglib代理
 * 默认cglib的代理会比jdk代理效率高，jdk的代理还有局限性，只能对接口类生成代理
 * cglib生成的代理既能对接口和类做代理
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableMyTransational
public class TransactionBeans {

}
