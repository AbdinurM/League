package com.abdinurmuse.league.Service;

import com.abdinurmuse.league.Repository.LeagueException;
import com.abdinurmuse.league.Models.Team;

import java.util.List;

public interface TeamService {
    void addTeam(Team newTeam) throws LeagueException;//add new team to db

    List<Team> getAllTeams() throws LeagueException;//get all team

    Team getTeam(int teamId) throws LeagueException;//get a team by id

    void deleteTeamByTeamId(int teamId) throws LeagueException;//delete team by id

    Team updateTeam(Team updateTeam) throws LeagueException;//update team



}
