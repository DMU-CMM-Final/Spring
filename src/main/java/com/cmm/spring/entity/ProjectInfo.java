package com.cmm.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@IdClass(ProjectInfo.class)
public class ProjectInfo {
    @Id
    private String node;
    @Id
    @Column(name="pId")
    private Integer pid;
    @Id
    @Column(name="tId")
    private Integer tid;
    @Column(name="dType")
    private String dtype;

    private String locate;

    private String scale;

}
