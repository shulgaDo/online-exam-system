package com.code.onlineexamsys.common.response;

import lombok.Getter;

@Getter
public enum ErrorCode {

    SYSTEM_ERROR(50000,"系统异常"),

    USER_NOT_EXIST(40001,"用户不存在"),
    PASSWORD_ERROR(40002,"密码错误"),

    PARAM_ERROR(40000,"参数错误");

    private final Integer code;

    private final String errorMessage;

    ErrorCode(Integer code,String errorMessage){
        this.code = code;
        this.errorMessage = errorMessage;
    }
}
