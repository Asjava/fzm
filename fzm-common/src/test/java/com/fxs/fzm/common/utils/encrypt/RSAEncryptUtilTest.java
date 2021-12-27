package com.fxs.fzm.common.utils.encrypt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RSAEncryptUtilTest {
    private String privateFilePath = "D:\\study\\auth_key\\id_key_rsa";
    private String publicFilePath = "D:\\study\\auth_key\\id_key_rsa.pub";

    @Test
    void generateKey() throws Exception {
        RSAEncryptUtil.generateKey(publicFilePath, privateFilePath, "fzm", 2048);
    }

    @Test
    void getPrivateKey() throws Exception {
        System.out.println(RSAEncryptUtil.getPrivateKey(privateFilePath));
    }

    @Test
    void getPublicKey() throws Exception {
        System.out.println(RSAEncryptUtil.getPublicKey(publicFilePath));
    }
}