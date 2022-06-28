package com.abdinurmuse.league.Repository;

import com.abdinurmuse.league.Models.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TeamRepositoryTest {

    @Autowired
    TeamRepository teamRepository;

    @Test
    void findbyteamId() {

        Team team = new Team(1, "Timberwolves", " Gray", 0, 0);

        teamRepository.save(team);

        Team retrievedTeam = teamRepository.findbyteamId(1);

        assertEquals(retrievedTeam, team);
    }
}