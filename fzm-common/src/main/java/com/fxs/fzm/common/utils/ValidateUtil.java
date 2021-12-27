package com.fxs.fzm.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Title:
 * Description:
 * Copyright: Copyright(c) 2019/7/1 0001
 * company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: xfh
 */
public class ValidateUtil {

    /**
     * 手机号码验证
     * @param val
     * @return
     */
    public static boolean isPhone(String val) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (val.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(val);
            if (!m.matches()) {
                return false;
            }
        }

        return true;
    }

    /**
     * email验证
     * @param val
     * @return
     */
    public static boolean checkEmail(String val){
        String regex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(val);
        if (!m.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 检验身份证是否合法(简单验证)
     * @param val
     * @return
     */
    public static boolean isIdCard(String val){
        int sum = 0;
        char[] checkBit = {'1','0','X','9','8','7','6','5','4','3','2'};
        int[] add = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
        char[] stringArr = val.toCharArray();
        for (int i=0 ; i<17 ; i++) {
            sum += add[i] * (stringArr[i] - '0');
        }
        if (stringArr[17] == checkBit[sum%11]) {
            return true;
        }
        return false;
    }

    /**
     * 验证是否正整数
     * @param val
     * @return
     */
    public static boolean isPositiveInteger(String val) {
        String regex = "^\\+?[1-9]\\d*$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(val);
        return m.find();
    }

}
