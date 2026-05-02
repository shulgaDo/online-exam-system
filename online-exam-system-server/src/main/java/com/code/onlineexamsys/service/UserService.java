package com.code.onlineexamsys.service;

import com.code.onlineexamsys.config.security.AuthUser;
import com.code.onlineexamsys.model.vo.LoginResponseVO;

public interface UserService {
    LoginResponseVO getLoginInfo(AuthUser authUser);
}
