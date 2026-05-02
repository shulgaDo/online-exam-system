package com.code.onlineexamsys.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class LoginRequest {

    @NotBlank(message = "用户名不能为空")
    @Size(min = 9,max = 9,message = "用户名必须为9位")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Size(min = 10,max = 20,message = "密码长度必须为10-20位")
    private String password;

}
