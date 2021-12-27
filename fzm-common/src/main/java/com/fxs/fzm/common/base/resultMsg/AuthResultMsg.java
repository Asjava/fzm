package com.fxs.fzm.common.base.resultMsg;

import com.fxs.fzm.common.enums.auth.AuthResultEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-17
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class AuthResultMsg {

    private static final long serialVersionUID = 1725159680599612404L;

    /**
     * 返回msg，object，以及token
     * 返回的code为默认
     * @param msg
     * @param data
     * @param jwtToken
     * @return
     */
    public final static  Map<String, Object> success(String msg, Object data,String jwtToken,Boolean success) {
        Map<String, Object> map = new HashMap<>();
        map.put("jwtToken",jwtToken);
        map.put("code", AuthResultEnum.SUCCESS.getCode());
        map.put("msg", msg);
        map.put("success",success);
        map.put("data", data);
        return map;
    }

    /**
     * 返回object，以及token
     * 返回的msg，code为默认
     * @param data
     * @param jwtToken
     * @return
     */
    public final static  Map<String, Object> success(Object data,String jwtToken) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("jwtToken",jwtToken);
        map.put("code", AuthResultEnum.SUCCESS.getCode());
        map.put("msg", AuthResultEnum.SUCCESS.getMsg());
        map.put("data", data);
        map.put("success",true);
        return map;
    }

    /**
     * 返回默认的信息
     * @return
     */
    public final static  Map<String, Object> success() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("jwtToken",null);
        map.put("code", AuthResultEnum.SUCCESS.getCode());
        map.put("msg", AuthResultEnum.SUCCESS.getMsg());
        map.put("data", null);
        map.put("success",true);
        return map;
    }

    public final static  Map<String, Object> failure(int code, String msg,Object data) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", data);
        map.put("success",false);
        return map;
    }

    public final static  Map<String, Object> failure(int code, String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", null);
        map.put("success",false);
        return map;
    }

    public final static  Map<String, Object> failure(AuthResultEnum respCode, Object data, Boolean success) {
        return getStringObjectMap(respCode, data,success);
    }

    public final static  Map<String, Object> failure(AuthResultEnum respCode, Boolean success) {
        return getStringObjectMap(respCode,success);
    }

    /*
     * 成功返回特定的状态码和信息
     * */
    public final static  Map<String, Object> result(AuthResultEnum respCode, Object data, Boolean success) {
        return getStringObjectMap(respCode, data,success);
    }

    private static  Map<String, Object> getStringObjectMap(AuthResultEnum respCode, Object data, Boolean success) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", respCode.getCode());
        map.put("msg", respCode.getMsg());
        map.put("data", data);
        map.put("success",success);
        return map;
    }

    /*
     * 成功返回特定的状态码和信息
     * */
    public final static  Map<String, Object> result(AuthResultEnum respCode, Boolean success) {
        return getStringObjectMap(respCode,success);
    }

    private static Map<String, Object> getStringObjectMap(AuthResultEnum respCode, Boolean success) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", respCode.getCode());
        map.put("msg", respCode.getMsg());
        map.put("data", null);
        map.put("success",success);
        return map;
    }

    /*
     * 成功返回特定的状态码和信息
     * */
    public final static Map<String, Object> result(AuthResultEnum respCode, String jwtToken, Boolean success) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("jwtToken",jwtToken);
        map.put("code", respCode.getCode());
        map.put("msg", respCode.getMsg());
        map.put("data", null);
        map.put("success",success);
        return map;
    }

}
