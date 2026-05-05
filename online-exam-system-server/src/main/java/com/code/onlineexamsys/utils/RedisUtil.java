package com.code.onlineexamsys.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public <T> void set(String key, T value, long timeout, TimeUnit unit){
        redisTemplate.opsForValue().set(key,value,timeout,unit);

    }

    public <T> void set(String key,T value){
        redisTemplate.opsForValue().set(key,value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key){
       return (T)redisTemplate.opsForValue().get(key);
    }

    public Boolean delete(String key){
        return redisTemplate.delete(key);
    }

    public Boolean hasKey(String key){
        return redisTemplate.hasKey(key);
    }

    public Boolean expire(String key,long timeout,TimeUnit unit){
        return redisTemplate.expire(key,timeout,unit);
    }

    public Long increment(String key,long delta){
        return redisTemplate.opsForValue().increment(key,delta);
    }

    public void hSet(String key,String field,Object value){
        redisTemplate.opsForHash().put(key,field,value);
    }

    public Object hGet(String key,String field){
        return redisTemplate.opsForHash().get(key,field);
    }
}
