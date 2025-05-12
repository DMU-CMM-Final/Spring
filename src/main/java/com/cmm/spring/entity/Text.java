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
@IdClass(TextId.class)
public class Text {
    @Id
    private String node;
    @Id
    @Column(name="pId")
    private Integer pid;
    @Id
    @Column(name="tId")
    private Integer tid;

    private String content;

    private String font;

    private String color;
    @Column(name="fontSize")
    private Integer fontsize;
}
