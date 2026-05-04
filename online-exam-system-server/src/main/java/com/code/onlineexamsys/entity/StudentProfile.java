package com.code.onlineexamsys.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "student_profile")
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "student_no", length = 50)
    private String studentNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;

    @Size(max = 255)
    @Column(name = "avatar")
    private String avatar;

    @Column(name = "academy_id")
    private Integer academyId;

    @Size(max = 255)
    @Column(name = "signature")
    private String signature;

    @Column(name = "major_id")
    private Integer majorId;

    @Column(name = "class_id")
    private Integer classId;

    @Size(max = 100)
    @Column(name = "email", length = 100)
    private String email;

    @Size(max = 20)
    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "gender")
    private Byte gender;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Size(max = 255)
    @Column(name = "address")
    private String address;

    @Column(name = "status")
    private Integer status;

}