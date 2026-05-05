package com.code.onlineexamsys.service;

import com.code.onlineexamsys.config.security.AuthUser;
import com.code.onlineexamsys.model.vo.LoginResponseVO;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
    LoginResponseVO getLoginInfo(AuthUser authUser);

    void logout(HttpServletRequest request);
}
