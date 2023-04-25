package com.fzm.netty.rpc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RpcRequestMessage {

    private Integer sequenceId;
    private String interfaceName;
    private String methodName;
    private Class<?> returnType;
    private Class<?>[] paramMeterType;
    private Object[] paramMeterValue;

}
