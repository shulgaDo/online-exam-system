package com.code.onlineexamsys.exception;

import com.code.onlineexamsys.common.response.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
    private final int code;

    public BusinessException(ErrorCode errorCode){
        super(errorCode.getErrorMessage());
        this.code = errorCode.getCode();
    }

}
