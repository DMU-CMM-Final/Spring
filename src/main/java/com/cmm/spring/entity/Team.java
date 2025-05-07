package com.cmm.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tId")
    private Integer tId;

    @Column(name = "tName", nullable = false)
    private String tName;

    @Column(name="uId")
    private String uId;

}
