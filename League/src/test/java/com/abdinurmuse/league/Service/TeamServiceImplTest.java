package com.abdinurmuse.league.Service;

import com.abdinurmuse.league.Repository.LeagueException;
import com.abdinurmuse.league.Models.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TeamServiceImplTest {

    @Autowired
    TeamServiceImpl teamService;

    @Test
    void getAllTeams() throws LeagueException {

        Team team = new Team(1, "Timberwolves", " Gray", 0, 0);

        teamService.addTeam(team);

        List<Team> teams = teamService.getAllTeams();

        assertEquals(teams.size(), 1);
        assertEquals(teams.get(0), team);


    }
}