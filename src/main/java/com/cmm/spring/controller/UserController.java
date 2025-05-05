package com.cmm.spring.controller;

import com.cmm.spring.dto.LoginRequest;
import com.cmm.spring.entity.User;
import com.cmm.spring.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원가입
    @PostMapping("/register")
    public Boolean register(@RequestBody User user) { // int 형으로 true false 값 넘기기
        return userService.register(user);
    }

    @GetMapping("/check-id") //id 필드의 내용을 비교
    public Boolean checkId(@RequestParam("id") String id) {
        return userService.checkEmail(id);
    }

    // 로그인 (비밀번호 직접 비교)
    @PostMapping("/login") // 아이디 값 넘겨주기
    public String login(@RequestBody LoginRequest lg) {
        return userService.login(lg);
    }
}
