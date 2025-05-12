package com.cmm.spring.service;

import com.cmm.spring.entity.Message;
import com.cmm.spring.entity.Team;
import com.cmm.spring.repository.MessageRepository;
import com.cmm.spring.repository.TeamRepository;
import com.cmm.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    public Team createTeam(String tname, String uid){
        if (userRepository.existsByUid(uid)){
            Team team = new Team();
            team.setTName(tname);
            team.setUId(uid);
            return teamRepository.save(team);
        }
        return null;
    }

    public boolean inviteTeam(String uid, Integer tid){
        if (userRepository.existsByUid(uid)){
            Message message = new Message();
            message.setUid(uid);
            message.setTid(tid);
            messageRepository.save(message);

            return true;
        } else {
            return false;
        }

    }

}
