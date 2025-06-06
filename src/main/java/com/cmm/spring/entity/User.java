package com.cmm.spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Users")
public class User {
    @Id
    @Column(name = "uId", length = 100)
    public String uid;

    @Column(name = "uName", nullable = false, length = 20)
    public String uname;

    @Column(name = "uPassword", length = 20)
    public String upassword;
}
