package com.code.onlineexamsys.handle;

import com.code.onlineexamsys.common.response.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ApiResponse<?> handlerException(Exception e){
        System.out.println(e.getMessage());
        return ApiResponse.failed();
    }
}
