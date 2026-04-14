package com.code.onlineexamsys.common.response;

import lombok.Data;

@Data
public class ApiResponse<T> {

    private Integer code;

    private String message;

    private T data;

    public ApiResponse(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public ApiResponse(Integer code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 请求成功
     * @return
     * @param <T>
     */
    public static <T> ApiResponse<T> success(){
        return new ApiResponse<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

    /**
     * 请求成功，返回响应数据
     * @param data
     * @return
     * @param <T>
     */
    public static <T> ApiResponse<T> success(T data){
       return new ApiResponse<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(),data);
    }

    /**
     * 请求失败
     * @return
     * @param <T>
     */
    public static <T> ApiResponse<T> failed(){
       return new ApiResponse<>(ResponseCode.FAILED.getCode(), ResponseCode.FAILED.getMessage());
    }

    /**
     * 请求失败,返回错误信息
     * @param responseCode
     * @return
     * @param <T>
     */
    public static <T> ApiResponse<T> failed(ResponseCode responseCode){
        return new ApiResponse<>(responseCode.getCode(),responseCode.getMessage(),null);
    }





}
