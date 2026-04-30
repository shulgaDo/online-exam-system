package com.code.onlineexamsys.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "exam_answers")
public class ExamAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "record_id")
    private Long recordId;

    @Column(name = "question_id")
    private Long questionId;

    @Lob
    @Column(name = "answer")
    private String answer;

    @Column(name = "is_correct")
    private Boolean isCorrect;

    @Column(name = "score", precision = 5, scale = 2)
    private BigDecimal score;

}