package com.BBall.League.Service;

import com.BBall.League.Repository.TeamException;
import com.BBall.League.Repository.TeamRepository;
import com.BBall.League.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Override
    public void addTeam(Team newTeam) throws TeamException {
        this.teamRepository.save(newTeam);
    }

    @Override
    public List<Team> getAllTeams() throws TeamException {
        return teamRepository.findAll();
    }

    @Override
    public Team getTeam(int teamId) throws TeamException {
        Optional<Team> optional = teamRepository.findById(teamId);
        Team team = null;
        if (optional.isPresent()) {
            team = optional.get();
        } else {
            throw new RuntimeException(" Sorry we can not locate the team you are looking for :: " + teamId);
        }
        return team;
    }

    @Override
    public void deleteTeamByTeamId(int teamId) throws TeamException {
    this.teamRepository.deleteById(teamId);
    }

    @Override
    public Team updateTeam(Team updateTeam) throws TeamException {
        return null;
    }

   // @Override
    //public Team getTeamPlayer(int teamId) throws TeamException {
      //  return teamRepository.findAllByteamId(teamId);
    //}


}
