package com.code.onlineexamsys.service.Impl;

import com.code.onlineexamsys.config.security.AuthUser;
import com.code.onlineexamsys.convert.StudentProfileConvert;
import com.code.onlineexamsys.entity.ClassInfo;
import com.code.onlineexamsys.entity.StudentProfile;
import com.code.onlineexamsys.enums.AcademyEnum;
import com.code.onlineexamsys.enums.MajorEnum;
import com.code.onlineexamsys.enums.StudentStatusEnum;
import com.code.onlineexamsys.exception.BusinessException;
import com.code.onlineexamsys.model.vo.LoginResponseVO;
import com.code.onlineexamsys.model.vo.UserInfoVO;
import com.code.onlineexamsys.repository.ClassInfoRepository;
import com.code.onlineexamsys.repository.PermissionRepository;
import com.code.onlineexamsys.repository.StudentProfileRepository;
import com.code.onlineexamsys.repository.UserRepository;
import com.code.onlineexamsys.service.TokenService;
import com.code.onlineexamsys.service.UserService;
import com.code.onlineexamsys.utils.EnumUtil;
import com.code.onlineexamsys.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Autowired
    private ClassInfoRepository classInfoRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private StudentProfileConvert studentProfileConvert;

    @Autowired
    private PermissionRepository permissionRepository;

    //TODO 待优化
    @Override
    public LoginResponseVO getLoginInfo(AuthUser authUser) {
        String token = jwtUtil.generateToken(authUser);
        Long id = authUser.getUser().getId();
        StudentProfile studentProfile = studentProfileRepository.findById(id)
                .orElseThrow(() -> new BusinessException("学生不存在"));
        ClassInfo classInfo = classInfoRepository.findNameById(studentProfile.getClassId());
        UserInfoVO userInfoVO = studentProfileConvert.toUserInfoVO(studentProfile);
        userInfoVO.setStatusDesc(EnumUtil.getByCode(StudentStatusEnum.class,studentProfile.getStatus()));
        userInfoVO.setAcademy(EnumUtil.getByCode(AcademyEnum.class,studentProfile.getAcademyId()));
        userInfoVO.setMajor(EnumUtil.getByCode(MajorEnum.class,studentProfile.getMajorId()));
        userInfoVO.setLoginTime(LocalDateTime.now());
        userInfoVO.setClassName(classInfo.getName());
        userInfoVO.setRoles(authUser.getRoles());
        userInfoVO.setPermissions(permissionRepository.findPermissionCodesByUserId(id));
        return new LoginResponseVO(token, userInfoVO);
    }

    @Override
    public void logout(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        long expire = jwtUtil.getExpire(token);
        tokenService.blacklist(token,expire);
    }
}
