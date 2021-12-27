package com.fxs.fzm.security.controller;

import com.fxs.fzm.common.cache.redis.RedisUtil;
import com.fxs.fzm.common.utils.VerifyCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 *
 * Description:用户相关接口
 * @author huangweicheng
 * @date 2019/10/22
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class VerifyController
{
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/verifyCode.jpg")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        /*禁止缓存*/
        response.setDateHeader("Expires",0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        /*获取验证码*/
        String code = VerifyCodeUtils.generateVerifyCode(4);
        /*验证码已key，value的形式缓存到redis 存放时间一分钟*/
        log.info("验证码============>" + code);
        String uuid = UUID.randomUUID().toString();
//        redisTemplate.opsForValue().set(uuid, code,1,TimeUnit.MINUTES);
        redisUtil.set(uuid, code, 1);
        Cookie cookie = new Cookie("captcha",uuid);
        /*key写入cookie，验证时获取*/
        response.addCookie(cookie);
        ServletOutputStream outputStream = response.getOutputStream();
        //ImageIO.write(bufferedImage,"jpg",outputStream);
        VerifyCodeUtils.outputImage(110,40,outputStream,code);
        outputStream.flush();
        outputStream.close();
    }
}
