package com.code.onlineexamsys.common.response;

import lombok.Getter;

@Getter
public enum ResponseCode {

    SUCCESS(200,"请求成功"),

    FAILED(500,"请求失败");

    private final Integer code;

    private final String message;

    ResponseCode(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
