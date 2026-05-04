package com.code.onlineexamsys.utils;

import com.code.onlineexamsys.enums.BaseEnum;
import com.code.onlineexamsys.enums.StudentStatusEnum;

/**
 * 枚举工具类
 */
public class EnumUtil {
    /**
     * 通过code得到对应的描述
     * @param enumClass
     * @param code
     * @return
     * @param <T>
     */
    public static <T extends Enum<T> & BaseEnum> String getByCode(Class<T> enumClass,Integer code){
        if(code == null){
            return null;
        }
        for (T e : enumClass.getEnumConstants()){
            if(e.getCode().equals(code)){
                return e.getDesc();
            }
        }
        return "未知";
    }
}
