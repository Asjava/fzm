package com.fxs.fzm.security.config;

import com.fxs.fzm.common.utils.encrypt.RSAEncryptUtil;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-13
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */

@ConfigurationProperties("rsa.key")
@Data
public class RsaKeyProperties {

    private String pubKeyFile;
    private String privateKeyFile;

    private PublicKey publicKey;
    private PrivateKey privateKey;

    @PostConstruct
    public void createRsaKey() throws Exception {
        publicKey = RSAEncryptUtil.getPublicKey(pubKeyFile);
        privateKey = RSAEncryptUtil.getPrivateKey(privateKeyFile);
    }

}
