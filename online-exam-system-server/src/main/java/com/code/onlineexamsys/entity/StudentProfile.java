package com.code.onlineexamsys.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student_profile")
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "real_name", length = 50)
    private String realName;

    @Column(name = "class_name", length = 50)
    private String className;

    @Column(name = "student_no", length = 50)
    private String studentNo;

}