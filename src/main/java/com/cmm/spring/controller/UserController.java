package com.cmm.spring.controller;

import com.cmm.spring.dto.*;
import com.cmm.spring.entity.User;
import com.cmm.spring.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/message")
    // uid, tid 받아서 message 조회, t_name, 팀장아이디 수락->true 거절->false
    // true 면 team_mem 에 추가, message 삭제
    // false 면 message 삭제, team 팀장 message 보내기 content=2
    public List<UserMessage> message(@RequestBody UidRequest uid) {
        return userService.myMessage(uid.getUid());
    }

    @PostMapping("/message/choice")
    public void messageChoice(@RequestBody ChoiceMessage choiceMessage) {
        userService.updateMessage(choiceMessage);
    }


}
