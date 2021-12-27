package com.fxs.fzm.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-10
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
@Component
@EnableBinding(Sink.class)
public class MessageConsume {

    @Value("${server.port}:8011")
    private String port;

    @StreamListener(Sink.INPUT)
    public void receive(Message<String> messageBody){
        System.out.println("server-port=========> "+ port +"=====> " + messageBody.getPayload().toString());
    }

}
