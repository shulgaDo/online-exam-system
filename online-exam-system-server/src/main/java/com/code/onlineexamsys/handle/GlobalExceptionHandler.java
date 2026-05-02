package com.code.onlineexamsys.handle;

import com.code.onlineexamsys.common.response.ApiResponse;
import com.code.onlineexamsys.common.response.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ApiResponse<?> handlerException(Exception e){
        log.error("系统异常："+e);
        return ApiResponse.failed(ErrorCode.SYSTEM_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<?> handlerValidException(MethodArgumentNotValidException e){
        String errorMsg = e.getBindingResult()
                .getFieldError()
                .getDefaultMessage();
        return ApiResponse.failed(errorMsg);
    }
}
