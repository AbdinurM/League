package com.BBall.League.Service;

import com.BBall.League.Repository.TeamException;
import com.BBall.League.models.Player;
import com.BBall.League.models.Team;

import java.util.List;

public interface TeamService {
    void addTeam(Team newTeam) throws TeamException;

    List<Team> getAllTeams() throws TeamException;

    Team getTeam(int teamId) throws TeamException;

    void deleteTeamByTeamId(int teamId) throws TeamException;

    Team updateTeam(Team updateTeam) throws TeamException;

   // Team getTeamPlayer(int teamId) throws TeamException;

}
