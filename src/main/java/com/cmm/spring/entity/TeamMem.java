package com.cmm.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@IdClass(TeamMemId.class)
public class TeamMem {
    @Id
    @Column(name="tId")
    private Integer tid;
    @Id
    @Column(name="uId")
    private String uid;

    private String role;
}
