package com.code.onlineexamsys.enums;

import lombok.Getter;

@Getter
public enum StudentStatusEnum implements BaseEnum{
    ONREAD(1,"在读"),
    GRADUATED(2, "毕业"),
    SUSPENDED(3, "休学"),
    DROPPED(4, "退学");


    private final Integer code;

    private final String desc;

    StudentStatusEnum(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }
}
