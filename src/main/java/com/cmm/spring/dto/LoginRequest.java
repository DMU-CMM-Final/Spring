package com.cmm.spring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String uId;
    private String uPassword;
}
