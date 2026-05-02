package com.code.onlineexamsys.controller;

import com.code.onlineexamsys.common.response.ApiResponse;
import com.code.onlineexamsys.config.security.AuthUser;
import com.code.onlineexamsys.model.request.LoginRequest;
import com.code.onlineexamsys.model.vo.LoginResponseVO;
import com.code.onlineexamsys.repository.UserRepository;
import com.code.onlineexamsys.service.UserService;
import com.code.onlineexamsys.utils.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "用户认证模块",description = "用户认证接口")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Operation(description = "用户登陆")
    @PostMapping("/login")
    public ApiResponse<LoginResponseVO> login(@Valid @RequestBody LoginRequest loginRequest){
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        AuthUser authUser = (AuthUser) authenticate.getPrincipal();
        LoginResponseVO loginResponseVO = userService.getLoginInfo(authUser);
        return ApiResponse.success(loginResponseVO);
    }

}
