package com.code.onlineexamsys.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "type")
    private String type;

    @Column(name = "options")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> options;

    @Lob
    @Column(name = "answer")
    private String answer;

    @Lob
    @Column(name = "analysis")
    private String analysis;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}