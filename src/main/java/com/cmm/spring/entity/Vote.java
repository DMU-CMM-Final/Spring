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
@IdClass(VoteId.class)
public class Vote {
    @Id
    private String node;
    @Id
    @Column(name="pId")
    private Integer pid;
    @Id
    @Column(name="tId")
    private Integer tid;

    private String title;
    private String list1;
    private String list2;
    private String list3;
    private String list4;
    @Column(name="list1Num")
    private Integer list1num;
    @Column(name="list2Num")
    private Integer list2num;
    @Column(name="list3Num")
    private Integer list3num;
    @Column(name="list4Num")
    private Integer list4num;

}
