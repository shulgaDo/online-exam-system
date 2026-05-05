package com.code.onlineexamsys.service.Impl;

import com.code.onlineexamsys.common.constant.RedisKeys;
import com.code.onlineexamsys.service.LoginUserService;
import com.code.onlineexamsys.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class LoginUserServiceImpl implements LoginUserService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void saveUser(Long userId, Object user, long expire) {
       redisUtil.set(
               RedisKeys.LOGIN_USER+userId,
               user,
               expire,
               TimeUnit.MINUTES
       );
    }

    @Override
    public <T> T getUser(Long userId) {
        return redisUtil.get(RedisKeys.LOGIN_USER + userId);
    }

    @Override
    public void removeUser(Long userId) {
        redisUtil.delete(RedisKeys.LOGIN_USER + userId);
    }
}
