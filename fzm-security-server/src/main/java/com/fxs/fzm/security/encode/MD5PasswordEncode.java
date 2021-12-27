package com.fxs.fzm.security.encode;

import com.fxs.fzm.common.utils.MD5Util;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-16
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class MD5PasswordEncode implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return MD5Util.md5((String)rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodePassword) {
        return encodePassword.equals(MD5Util.md5((String)rawPassword));
    }
}
