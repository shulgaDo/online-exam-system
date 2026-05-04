package com.code.onlineexamsys.enums;

import lombok.Getter;

@Getter
public enum MajorEnum implements BaseEnum{

    SOFTWARE_ENGINEERING(1, "软件工程"),
    COMPUTER_SCIENCE(2, "计算机科学"),
    NETWORK_ENGINEERING(3, "网络工程"),
    MUSIC_PERFORMANCE(4, "音乐表演"),
    SPORTS_TRAINING(5, "体育训练");

    private final Integer code;

    private final String desc;

    MajorEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
