package com.code.onlineexamsys.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "paper_downloads")
public class PaperDownload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "paper_id")
    private Long paperId;

    @Column(name = "downloaded_at")
    private LocalDateTime downloadedAt;

}