package com.code.onlineexamsys.enums;

import lombok.Getter;

@Getter
public enum AcademyEnum implements BaseEnum{
    ENGINEERING(1, "工学院"),
    MUSIC(2, "音乐学院"),
    SPORTS(3, "体育学院");

    private final Integer code;

    private final String desc;

    AcademyEnum(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }
}
