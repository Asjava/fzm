package com.fxs.fzm.security.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fxs.fzm.security.bean.PayLoad;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * Title: JWT的工具类
 * Description:JWT的工具类
 * Copyright: Copyright (c) 2019年6月26日
 * Company: 北京福富软件技术股份有限公司福州分公司
 * @author: zenggq
 */

public class JwtUtil {

    public static final String SUBJECT = "fzm";

    //秘钥
    public static final String APPSECRET = "fzmsecurity";

    //用户key
    public static final String JWT_PAYLOAD_USER_KEY = "user";

    //10天过期时间
    private static final Long ttl = Long.valueOf(10*24*60*60*1000);

    /**
     * 生成app用户jwt
     *
     * @return
     */
    public static String generateTokenExpireInSeconds(Object userInfo, PrivateKey privateKey, int expire) {
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim(JWT_PAYLOAD_USER_KEY, JSON.toJSONString(userInfo))
                .setIssuedAt(new Date())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256, privateKey)
                .compact();
        return token;
    }


    /**
     * 获取token中的用户信息
     * @return
     */
    public static <T> PayLoad<T> getInfoFromToken(String token, PublicKey publicKey, Class<T> userType) {
        Claims body = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token).getBody();
        PayLoad<T> claims = new PayLoad<>();
        claims.setId(body.getId());
        claims.setUserInfo(JSONObject.toJavaObject(JSON.parseObject(body.get(JWT_PAYLOAD_USER_KEY).toString()), userType));
        claims.setExpiration(body.getExpiration());
        return claims;
    }

    private static String createJTI() {
        return new String(Base64.getEncoder().encode(UUID.randomUUID().toString().getBytes()));
    }

    /**
     * 校验JWT
     *
     * @param token
     * @return
     */
    public static Claims checkJWT(String token) {
        try {
            return Jwts.parser().setSigningKey(APPSECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 校验JWT
     *
     * @param token
     * @return
     */
    public static Claims checkJWT(String token, String appsecret) {
        try {
            return Jwts.parser().setSigningKey(appsecret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return null;
        }
    }
}
