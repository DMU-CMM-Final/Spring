package com.cmm.spring.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Users")
public class User {
    @Id
    @Column(name = "uId", length = 20)
    private String uid;

    @Column(name = "uName", nullable = false, length = 20)
    private String uname;

    @Column(name = "uPassword", nullable = false, length = 20)
    private String upassword;

    @Column(name = "uTel", length = 20)
    private String utel;
}
