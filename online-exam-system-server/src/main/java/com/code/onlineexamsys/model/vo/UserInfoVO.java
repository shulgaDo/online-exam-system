package com.code.onlineexamsys.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserInfoVO {

    private Long id;

    private String name;

    private String studentNo;

    private String avatar;

    private List<String> roles;

    private List<String> permissions;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private LocalDateTime loginTime;

    private String academy;

    private String major;

    private String className;

    private String signature;

    private String statusDesc;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

}
