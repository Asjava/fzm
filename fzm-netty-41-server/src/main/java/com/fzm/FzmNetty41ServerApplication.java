package com.fzm;

import com.fzm.netty.rpc.bean.RpcRequestMessage;
import com.fzm.netty.rpc.service.BasketballMan;
import com.fzm.netty.rpc.service.Person;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

@SpringBootApplication
public class FzmNetty41ServerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FzmNetty41ServerApplication.class, args);

        RpcRequestMessage rpcRequestMessage = new RpcRequestMessage(1,
                "com.fzm.netty.rpc.service.Person",
                "say",
                String.class,
                new Class[]{String.class},
                new Object[]{"张三"});

        Map<String, Person> beansOfType = context.getBeansOfType(Person.class);
        Collection<Person> values = beansOfType.values();
        values.forEach(service-> {
            if (service instanceof BasketballMan) {
                Method method = null;
                try {
                    method = service.getClass().getMethod(rpcRequestMessage.getMethodName(), rpcRequestMessage.getParamMeterType());
                    Object invoke = method.invoke(service, rpcRequestMessage.getParamMeterValue());
                    System.out.println(invoke);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
