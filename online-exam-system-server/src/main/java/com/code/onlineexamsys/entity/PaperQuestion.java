package com.code.onlineexamsys.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "paper_questions")
public class PaperQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "paper_id")
    private Long paperId;

    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "score")
    private Integer score;

    @Column(name = "sort_order")
    private Integer sortOrder;

}