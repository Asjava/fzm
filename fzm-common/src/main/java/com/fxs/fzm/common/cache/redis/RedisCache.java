package com.fxs.fzm.common.cache.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component("redisCache")
public class RedisCache implements Cache {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Object getAndSet(CacheClosure cacheClosure) {
        Object json = null;
        try {
            json = redisTemplate.opsForValue().get(cacheClosure.getKey());

            if (null == json) {
                Object value = cacheClosure.getValue();
                if (null != value) {
                    json = JsonUtils.objectToJson(value);
                } else if (cacheClosure.getIfNullSetDefaultValue()) {
                    json = cacheClosure.getIfNullDefaultValue();
                }

                if (null != json) {
                    if (null == cacheClosure.getTime()) {
                        redisTemplate.opsForValue().set(cacheClosure.getKey(),json);
                    } else {
                        redisTemplate.opsForValue().set(cacheClosure.getKey(),json, cacheClosure.getTime());
                    }
                }
                return value;
            } else {
                if (cacheClosure.getIfNullSetDefaultValue()) {
                    if (json.equals(cacheClosure.getIfNullDefaultValue())) {
                        return null;
                    }
                }
                return JsonUtils.jsonToObject(json.toString(), cacheClosure.getTypeReference());
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void del(String key) {
        try {
            redisTemplate.delete(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object get(CacheClosure cacheClosure) {
        Object json = null;
        try {
            json =  redisTemplate.opsForValue().get(cacheClosure.getKey());
            if (null == json) {
                return null;
            } else {
                if (cacheClosure.getIfNullSetDefaultValue()) {
                    if (json.equals(cacheClosure.getIfNullDefaultValue())) {
                        return null;
                    }
                }
                return JsonUtils.jsonToObject(json.toString(), cacheClosure.getTypeReference());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object set(CacheClosure cacheClosure) {
        Object value = cacheClosure.getValue();
        try {
            if (null != value) {
                String json = JsonUtils.objectToJson(value);
                if (null == cacheClosure.getTime()) {
                    redisTemplate.opsForValue().set(cacheClosure.getKey(),json);
                } else {
                    redisTemplate.opsForValue().set(cacheClosure.getKey(),json, cacheClosure.getTime());
                }
            } else {
                if (cacheClosure.getIfNullSetDefaultValue()) {
                    if (null == cacheClosure.getTime()) {
                        redisTemplate.opsForValue().set(cacheClosure.getKey(),cacheClosure.getIfNullDefaultValue());
                    } else {
                        redisTemplate.opsForValue().set(cacheClosure.getKey(),cacheClosure.getIfNullDefaultValue(), cacheClosure.getTime());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return value;
    }

    @Override
    public void setTimeout(String key, long seconds) {
        try {
            if (seconds > 0) {
                redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public long increment(String key, long value) {
        try {
            return redisTemplate.opsForValue().increment(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
