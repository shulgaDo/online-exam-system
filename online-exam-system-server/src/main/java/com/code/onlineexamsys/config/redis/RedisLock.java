package com.code.onlineexamsys.config.redis;

import com.code.onlineexamsys.common.constant.RedisKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisLock {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public boolean tryLock(String key, long timeout, TimeUnit unit){
        Boolean success = redisTemplate.opsForValue()
                .setIfAbsent(RedisKeys.LOCK, "1", timeout, unit);
        return Boolean.TRUE.equals(success);
    }

    public void unlock(String key){
        redisTemplate.delete(RedisKeys.LOCK + key);
    }
}
