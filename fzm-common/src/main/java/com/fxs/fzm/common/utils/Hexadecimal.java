package com.fxs.fzm.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 标题
 * 描述
 * Copyright: Copyright (c) ${Date}
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: KeiVi233
 */
public class Hexadecimal {


    /**
     * 字符串转换成为16进制(无需Unicode编码)
     * @param str
     * @return
     */
    public static String str2HexStr(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
            // sb.append(' ');
        }
        return sb.toString().trim();
    }

    /**
     * 16进制直接转换成为字符串(无需Unicode解码)
     * @param hexStr
     * @return
     */
    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }


    /**
     * 处理返回对象
     * 对返回参数加密
     */
    public static String processOutPutObj(String o) {
         String cipherText = null;
        try {
            // 获取data
//            JSONObject json = (JSONObject) JSON.toJSON(o);
//            String plainText = JSONObject.toJSONString(json);

            cipherText =  Hexadecimal.str2HexStr(o);
            // 重新放入Object中
         } catch (Exception e) {
            e.printStackTrace();
        }
        return cipherText ;
    }

    /**
     * 处理输入参数
     * 对入参进行解密
     *
     * @param plain 加密后的入参
     */
    public static String processInputArg(String plain) {
        String plainText = null;
        try {
            if (StringUtils.isEmpty(plain)) {
                return plainText;
            }
            plainText = Hexadecimal.hexStr2Str(plain);

        } catch (Exception e) {
            e.printStackTrace();
            return plainText;
        }
        return plainText;
    }

}
