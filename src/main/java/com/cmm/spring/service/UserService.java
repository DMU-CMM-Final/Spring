package com.cmm.spring.service;

import com.cmm.spring.dto.ChoiceMessage;
import com.cmm.spring.dto.LoginRequest;
import com.cmm.spring.dto.UserMessage;
import com.cmm.spring.entity.*;
import com.cmm.spring.repository.MessageRepository;
import com.cmm.spring.repository.TeamMemRepository;
import com.cmm.spring.repository.TeamRepository;
import com.cmm.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TeamMemRepository teamMemRepository;

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
    public String login(@RequestBody LoginRequest lg) {
        return userRepository.findById(lg.getUId())
                .filter(u -> u.getUpassword().equals(lg.getUPassword()))
                .map(u -> lg.getUId())
                .orElse("로그인 실패!");
    }

    // uid, tid 받아서 message 조회, t_name, 팀장아이디 수락->true 거절->false
    // true 면 team_mem 에 추가, message 삭제
    // false 면 message 삭제, team 팀장 message 보내기 content=2
    public List<UserMessage> myMessage(String uid) {
        List<Message> message = messageRepository.findByUid(uid);
        List<UserMessage> userMessage = new ArrayList<>();
        System.out.println("message.size() = " + message.size());

        for (Message m : message) {
            Integer tid = m.getTid();
            Team team = teamRepository.findById(tid)
                    .orElseThrow(() -> new RuntimeException("Team not found"));
            UserMessage userM = new UserMessage();
            userM.setTname(team.getTName());
            userM.setUid(team.getUId());
            userM.setContent(m.getContent());
            userMessage.add(userM);
        }

        return userMessage;
    }

    public void updateMessage(ChoiceMessage message) {
        Team team = teamRepository.findById(message.getTid()).orElse(null);
        MessageId messageId = new MessageId(message.getUid(),message.getTid());
        messageRepository.deleteById(messageId);
        System.out.println(messageId.toString()+" 삭제");

        if (message.getBool()){
            TeamMem teamMem = new TeamMem();
            teamMem.setTid(message.getTid());
            teamMem.setUid(message.getUid());
            teamMem.setRole("팀원");
            teamMemRepository.save(teamMem);
            System.out.println(teamMem.toString()+" 저장");
        } else {
            Message ms = new Message();
            ms.setUid(team.getUId());
            ms.setTid(team.getTId());
            ms.setContent(2);
            messageRepository.save(ms);
            System.out.println(ms.getUid()+" 메세지 전달");
        }
    }
}

