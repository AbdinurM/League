package com.abdinurmuse.league.Service;

import com.abdinurmuse.league.Repository.LeagueException;
import com.abdinurmuse.league.Repository.TeamRepository;
import com.abdinurmuse.league.Models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Override
    public void addTeam(Team newTeam) throws LeagueException {
        this.teamRepository.save(newTeam);
    }

    @Override
    public List<Team> getAllTeams() throws LeagueException {
        return teamRepository.findAll();
    }

    @Override
    public Team getTeam(int teamId) throws LeagueException {
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
    public void deleteTeamByTeamId(int teamId) throws LeagueException {
    this.teamRepository.deleteById(teamId);
    }

    @Override
    public Team updateTeam(Team updateTeam) throws LeagueException {
        return null;
    }

 //   @Override
  //  public List<Player> findbyteamid(int teamId) throws TeamException {
 //       return findbyteamid(teamId);
  //  }


}
