package com.cmm.spring.service;

import com.cmm.spring.dto.LoginRequest;
import com.cmm.spring.entity.User;
import com.cmm.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public Boolean register(@RequestBody User user) {
        if(userRepository.existsByUid(user.getUid())) {
            System.out.print("회원가입 실패: 중복된 ID입니다.");
            return false;
        }
        try {
            userRepository.save(user);
            System.out.print("회원가입 성공!");
            return true;
        } catch (Exception e) {
            System.out.print("회원가입 실패: " + e.getMessage());
            return false;
        }
    }

    public boolean checkEmail(String id) {
        return userRepository.existsByUid(id);
    }

    // 로그인 (비밀번호 직접 비교)
    @PostMapping("/login") // 아이디 값 넘겨주기
    public String login(@RequestBody LoginRequest lg) {
        return userRepository.findById(lg.getUId())
                .filter(u -> u.getUpassword().equals(lg.getUPassword()))
                .map(u -> lg.getUId())
                .orElse("로그인 실패!");
    }
}

