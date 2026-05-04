package com.code.onlineexamsys.enums;

import lombok.Getter;

@Getter
public enum GenderEnum implements BaseEnum{

    MALE(1,"男"),
    FEMALE(0,"女");

    private final Integer code;

    private final String desc;

    GenderEnum(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }
}
