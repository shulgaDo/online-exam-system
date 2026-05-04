package com.code.onlineexamsys.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dict")
public class Dict {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Column(name = "type", length = 100)
    private String type;

    @Column(name = "code")
    private Integer code;

    @Size(max = 100)
    @Column(name = "name", length = 100)
    private String name;

}