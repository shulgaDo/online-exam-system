package com.code.onlineexamsys.service.Impl;

import com.code.onlineexamsys.common.constant.RedisKeys;
import com.code.onlineexamsys.service.TokenService;
import com.code.onlineexamsys.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void blacklist(String token, long expire) {
        redisUtil.set(
                RedisKeys.TOKEN_BLACKLIST+token,
                1,
                expire,
                TimeUnit.MILLISECONDS
        );
    }

    @Override
    public boolean isBlackListed(String token) {
        return redisUtil.hasKey(token);
    }
}
