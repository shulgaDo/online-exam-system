package com.code.onlineexamsys.convert;

import com.code.onlineexamsys.config.security.AuthUser;
import com.code.onlineexamsys.entity.StudentProfile;
import com.code.onlineexamsys.model.vo.UserInfoVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentProfileConvert {
    UserInfoVO toUserInfoVO(StudentProfile studentProfile);
}
