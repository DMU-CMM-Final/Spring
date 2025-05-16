package com.cmm.spring.service;

import com.cmm.spring.entity.Message;
import com.cmm.spring.entity.Team;
import com.cmm.spring.entity.TeamMem;
import com.cmm.spring.repository.MessageRepository;
import com.cmm.spring.repository.TeamMemRepository;
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

    @Autowired
    private TeamMemRepository teamMemRepository;

    public Integer createTeam(String tname, String uid){
        if (userRepository.existsByUid(uid)){
            Team team = new Team();
            TeamMem teamMem = new TeamMem();
            team.setTName(tname);
            team.setUId(uid);
            teamRepository.save(team);

            teamMem.setTid(team.getTId());
            teamMem.setUid(team.getUId());
            teamMem.setRole("팀장");
            teamMemRepository.save(teamMem);

            return team.getTId();
        }
        return 0;
    }

    public boolean inviteTeam(String uid, Integer tid){
        if (userRepository.existsByUid(uid)){
            Message message = new Message();
            message.setUid(uid);
            message.setTid(tid);
            message.setContent(1);
            messageRepository.save(message);

            return true;
        } else {
            return false;
        }

    }

}
