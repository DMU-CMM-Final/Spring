package com.cmm.spring.controller;

import com.cmm.spring.dto.InviteMessage;
import com.cmm.spring.dto.TeamCreateRequest;
import com.cmm.spring.dto.TeamList;
import com.cmm.spring.dto.UidRequest;
import com.cmm.spring.entity.MessageId;
import com.cmm.spring.entity.Team;
import com.cmm.spring.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @PostMapping("/create")
    public Integer createTeam(@RequestBody TeamCreateRequest team) {
        return teamService.createTeam(team.getTname(), team.getUid());
    }

    @PostMapping("/message")
    public Boolean inviteTeam(@RequestBody InviteMessage inviteMessage) {
        return teamService.inviteTeam(inviteMessage.getUid(), inviteMessage.getTid());
    }

    @PostMapping("/message/delete")
    public void deleteTeam(@RequestBody MessageId messageId) {
        teamService.deleteMem(messageId.getTid(), messageId.getUid());
    }

    @PostMapping("/list")
    public List<TeamList> teamList(@RequestBody UidRequest uid) {
        return teamService.myTeamList(uid.getUid());
    }

}