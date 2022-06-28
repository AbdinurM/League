package com.abdinurmuse.league.Service;

import com.abdinurmuse.league.Repository.LeagueException;
import com.abdinurmuse.league.Models.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PlayerServiceImplTest  {

    @Autowired
    PlayerServiceImpl playerService;

    @Test
    void getAllPlayer() throws LeagueException {

        Player player = new Player(1, 1, "Abdinur", 26, 10, "SMALL_FORWARD", 0.0, 0.0, 0.0, 0.0);
        playerService.addPlayer(player);
        List<Player> players = playerService.getAllPlayer();

        assertEquals(players.size(), 1);
        assertEquals(players.get(0), player);
    }
}