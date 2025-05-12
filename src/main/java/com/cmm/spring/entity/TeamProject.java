package com.cmm.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@IdClass(TeamProjectId.class)
public class TeamProject {
    @Id
    @Column(name="pId")
    private Integer pid;
    @Id
    @Column(name="tId")
    private Integer tid;
    @Column(name="pName")
    private String pname;
    @Column(name="createDate")
    private Date createdate;
}
