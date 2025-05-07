package com.cmm.spring.service;

import com.cmm.spring.entity.Team;
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

    public Team createTeam(String tname, String uid){
        if (userRepository.existsByUid(uid)){
            Team team = new Team();
            team.setTName(tname);
            team.setUId(uid);
            return teamRepository.save(team);
        }
        return null;
    }

}
