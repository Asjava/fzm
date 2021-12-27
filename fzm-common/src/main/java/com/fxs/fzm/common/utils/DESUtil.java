package com.fxs.fzm.common.utils;

/**
 * 3DES加密工具类
 *
 * @author kx
 * */

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;

public class DESUtil {
    // 密钥
    private final static String secretKey = "huijin12345@lx100$#365#$";
    // 向量
    private final static String iv = "huijin66";
    // 加解密统一使用的编码方式
    private final static String encoding = "utf-8";
    /**
     * 3DES加密
     *
     * @param plainText 普通文本
     * @return
     * @throws Exception
     */
    public static String encode(String plainText) {
        Key deskey = null;
        try {
            DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
            SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
            deskey = keyfactory.generateSecret(spec);

            Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
            IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
            byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
            return Base64.encodeBase64String(encryptData);
        } catch (Exception e) {
            e.printStackTrace();
            return plainText;
        }
    }

    /**
     * 3DES解密
     *
     * @param encryptText 加密文本
     * @return
     * @throws Exception
     */
    public static String decode(String encryptText) {
        Key deskey = null;
        try {
            DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
            SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
            deskey = keyfactory.generateSecret(spec);
            Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
            IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, deskey, ips);

            byte[] decryptData = cipher.doFinal(Base64.decodeBase64(encryptText));
            return new String(decryptData, encoding);
        } catch (Exception e) {
            e.printStackTrace();
            return encryptText;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(encode("FRveKaJakcMwwjOW"));
            System.out.println(decode("vqDfvTcj6LJDNm3lYU28kA=="));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
