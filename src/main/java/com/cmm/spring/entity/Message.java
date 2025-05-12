package com.cmm.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@IdClass(MessageId.class)
public class Message {
    @Id
    @Column(name="uId")
    private String uid;
    @Id
    @Column(name="tId")
    private Integer tid;
}
