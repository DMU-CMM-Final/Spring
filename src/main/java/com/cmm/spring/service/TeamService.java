package com.cmm.spring.service;

import com.cmm.spring.dto.TeamList;
import com.cmm.spring.entity.*;
import com.cmm.spring.repository.MessageRepository;
import com.cmm.spring.repository.TeamMemRepository;
import com.cmm.spring.repository.TeamRepository;
import com.cmm.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public void cancelMem(Integer tid, String uid){
        MessageId mId = new MessageId(uid,tid);
        Message m = messageRepository.findById(mId).orElse(null);
        if (m!=null){
            messageRepository.delete(m);
            System.out.println(m.getUid()+" 초대 취소");
        }
        System.out.println("팀원 조회 실패");
    }

    public void deleteMember(String uid, Integer tid){
        TeamMemId memId = new TeamMemId();
        memId.setTid(tid);
        memId.setUid(uid);
        TeamMem mem = teamMemRepository.findById(memId).orElse(null);
        teamMemRepository.delete(mem);
        System.out.println(mem.getUid()+" 팀원 삭제");
    }

    public List<TeamList> myTeamList(String uid){
        List<TeamList> teamList = new ArrayList<>();
        List<TeamMem> teamMem = teamMemRepository.findByUid(uid);
        for (TeamMem t : teamMem) {
            Team team = teamRepository.findById(t.getTid()).orElse(null);
            if (team!=null){
                TeamList tl = new TeamList();
                tl.setTid(team.getTId());
                tl.setTname(team.getTName());
                teamList.add(tl);
            } else {
                System.out.println("조회된 팀 없음");
            }
        }
        System.out.println(teamList.size()+"개의 팀 보유");
        return teamList;


    }

}
