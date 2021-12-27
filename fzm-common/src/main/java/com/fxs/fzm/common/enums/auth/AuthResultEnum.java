package com.fxs.fzm.common.enums.auth;

import lombok.Getter;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-17
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
@Getter
public enum AuthResultEnum {

    SUCCESS(101,"成功"),
    FAILURE(102,"失败"),
    USER_NEED_AUTHORITIES(201,"用户未登录"),
    USER_LOGIN_FAILED(202,"用户账号或密码错误"),
    USER_LOGIN_SUCCESS(203,"用户登录成功"),
    USER_NO_ACCESS(204,"用户无权访问"),
    USER_LOGOUT_SUCCESS(205,"用户登出成功"),
    TOKEN_IS_BLACKLIST(206,"此token为黑名单"),
    LOGIN_IS_OVERDUE(207,"登录已失效"),
    VERIFY_CODE_ERROR(208,"验证码错误");

    private Integer code;

    private String msg;


    AuthResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static AuthResultEnum parse(int code){
        AuthResultEnum[] values = AuthResultEnum.values();
        for (AuthResultEnum value : values) {
            if (value.getCode() == code){
                return value;
            }
        }
        throw  new RuntimeException("未知异常");
    }

    public static String getName(int code){
        AuthResultEnum[] values = AuthResultEnum.values();
        for (AuthResultEnum value : values) {
            if (value.getCode() == code){
                return value.getMsg();
            }
        }
        return "未知";
    }

}
