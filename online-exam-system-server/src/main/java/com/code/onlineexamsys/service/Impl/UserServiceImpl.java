package com.code.onlineexamsys.service.Impl;

import com.code.onlineexamsys.config.security.AuthUser;
import com.code.onlineexamsys.model.vo.LoginResponseVO;
import com.code.onlineexamsys.repository.UserRepository;
import com.code.onlineexamsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public LoginResponseVO getLoginInfo(AuthUser authUser) {
        return null;
    }
}
