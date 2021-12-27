package com.fxs.fzm.common.cache.redis;

import com.fxs.fzm.common.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class RedissonDemo {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public String getMessage(){

        String key = "demoLock";
        String uuid = UUID.randomUUID().toString();
        try {
//            Boolean result = redisTemplate.opsForValue().setIfAbsent(key, uuid);
//            redisTemplate.expire(key,10, TimeUnit.SECONDS);
            Boolean result = redisTemplate.opsForValue().setIfAbsent(key, uuid, 10, TimeUnit.SECONDS);
            if (!result) {
                return "error";
            }
        } finally {
            if(uuid.equals(redisTemplate.opsForValue().get(key))){
                redisTemplate.delete(key);
            }
        }

        return Constant.RESULT_MSG_ADD_SUCCESS;
    }
}
