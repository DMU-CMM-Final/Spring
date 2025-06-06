package com.cmm.spring.dto;

import com.cmm.spring.entity.User;
import lombok.Data;

@Data
public class LoginResponseDto {
    public boolean loginSuccess;
    public User user;
}
