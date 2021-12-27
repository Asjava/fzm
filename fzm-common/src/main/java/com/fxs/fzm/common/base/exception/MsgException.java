package com.fxs.fzm.common.base.exception;

/**
 * Title: 自定义异常，用于提示用户异常消息
 * Description:
 * Copyright: Copyright(c) 2019/10/12 0012
 * company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: xfh
 */
public class MsgException extends RuntimeException {
    public MsgException(String message) {
        super(message);
    }
}
