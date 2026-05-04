package com.code.onlineexamsys.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseVO {

    private String token;

    private UserInfoVO userinfoVO;

}
