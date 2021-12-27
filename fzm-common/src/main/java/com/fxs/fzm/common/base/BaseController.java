package com.fxs.fzm.common.base;


import com.alibaba.fastjson.JSONObject;
import com.fxs.fzm.common.constant.Constant;
import com.fxs.fzm.common.utils.Page;
import com.fxs.fzm.common.utils.ParseUtil;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

    /**
     * 将resultMap转换成json打印到前端
     */
    public String printResultMap(Map<String, Object> resultMap) {
        try {
            JSONObject json = (JSONObject) JSONObject.toJSON(resultMap);
            return json.toJSONString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 设置简单的返回到前端的成功的消息map值
     * 即返回到前端的map只有success: true, msg: 保存成功
     */
    public void setUpdateSuccessMap(Map<String, Object> resultMap) {
        resultMap.put(Constant.RESULT_CODE, Constant.RESULT_CODE_SUCCESS);
        resultMap.put(Constant.RESULT_MSG, Constant.RESULT_MSG_UPDATE_SUCCESS);
    }

    /**
     * 设置简单的返回到前端的成功的消息map值
     * 即返回到前端的map只有success: false, msg: 保存失败
     */
    public void setUpdateFailureMap(Map<String, Object> resultMap) {
        resultMap.put(Constant.RESULT_CODE, Constant.RESULT_CODE_FAILURE);
        resultMap.put(Constant.RESULT_MSG, Constant.RESULT_MSG_UPDATE_FAILURE);
    }

    public void setAddSuccessMap(Map<String, Object> resultMap) {
        resultMap.put(Constant.RESULT_CODE, Constant.RESULT_CODE_SUCCESS);
        resultMap.put(Constant.RESULT_MSG, Constant.RESULT_MSG_ADD_SUCCESS);
    }

    public void setAddFailureMap(Map<String, Object> resultMap) {
        resultMap.put(Constant.RESULT_CODE, Constant.RESULT_CODE_FAILURE);
        resultMap.put(Constant.RESULT_MSG, Constant.RESULT_MSG_ADD_FAILURE);
    }

    public void setDeleteSuccessMap(Map<String, Object> resultMap) {
        resultMap.put(Constant.RESULT_CODE, Constant.RESULT_CODE_SUCCESS);
        resultMap.put(Constant.RESULT_MSG, Constant.RESULT_MSG_DELETE_SUCCESS);
    }

    public void setDeleteFailureMap(Map<String, Object> resultMap) {
        resultMap.put(Constant.RESULT_CODE, Constant.RESULT_CODE_FAILURE);
        resultMap.put(Constant.RESULT_MSG, Constant.RESULT_MSG_DELETE_FAILURE);
    }

    public void setQuerySuccessMap(Map<String, Object> resultMap) {
        resultMap.put(Constant.RESULT_CODE, Constant.RESULT_CODE_SUCCESS);
        resultMap.put(Constant.RESULT_MSG, Constant.RESULT_MSG_QUERY_SUCCESS);
    }

    public void setQuerySuccessMap(Map<String, Object> resultMap, Object object) {
        setQuerySuccessMap(resultMap);
        resultMap.put(Constant.RESULT_DATA, object);
    }

    public void setQueryFailureMap(Map<String, Object> resultMap) {
        resultMap.put(Constant.RESULT_CODE, Constant.RESULT_CODE_FAILURE);
        resultMap.put(Constant.RESULT_MSG, Constant.RESULT_MSG_QUERY_FAILURE);
    }

    /**
     * 自定义设置成功的消息
     *
     * @param msg
     */
    public void setSuccessMap(Map<String, Object> resultMap, String msg) {
        resultMap.put(Constant.RESULT_CODE, Constant.RESULT_CODE_SUCCESS);
        resultMap.put(Constant.RESULT_MSG, msg);
    }

    public void setSuccessDataMap(Map<String, Object> resultMap, String msg, Object object) {
        resultMap.put(Constant.RESULT_DATA, object);
        setSuccessMap(resultMap, msg);
    }


    /**
     * 自定义设置失败的消息
     *
     * @param msg
     */
    public static void setFailureMap(Map<String, Object> resultMap, String msg) {
        resultMap.put(Constant.RESULT_CODE, Constant.RESULT_CODE_FAILURE);
        resultMap.put(Constant.RESULT_MSG, msg);
    }

    public static void setFailureDataMap(Map<String, Object> resultMap, String msg, Object object) {
        resultMap.put(Constant.RESULT_DATA, object);
        setFailureMap(resultMap, msg);
    }

    public Map<String, Object> getParameter(HttpServletRequest request) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        String limitStr = request.getParameter(Constant.PAGE_SIZE);
        if (!StringUtils.isEmpty(limitStr)) {
            limitStr = limitStr.trim();
            int limit = ParseUtil.parseInt(limitStr);
            paramMap.put(Constant.PAGE_SIZE, limitStr);
        }
        String pageStr = request.getParameter(Constant.PAGE_NUM);
        if (!StringUtils.isEmpty(pageStr)) {
            pageStr = pageStr.trim();
            int page = ParseUtil.parseInt(pageStr);
            paramMap.put(Constant.PAGE_NUM, page);
        }
        Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = request.getParameter(name);
            paramMap.put(name, value);
        }
        return paramMap;
    }

    public static void response(HttpServletResponse response, String body) {
        try {
            response.setCharacterEncoding(Constant.ENCODE_MODE);
            response.getWriter().print(body);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception ex) {

        }
    }

    public static void responseJson(HttpServletResponse response, Map<String, Object> resultMap) {
        try {
            String json = JSONObject.toJSONString(resultMap);
            response(response, json);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void responseJson(HttpServletResponse response, Page page) {
        try {
            response.setContentType(Constant.CONTENT_TYPE_JSON);
            String json = JSONObject.toJSONString(page);
            response(response, json);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String toJsonString(Object object) {
        return JSONObject.toJSONString(object);
    }

}
