package com.abdinurmuse.league.Repository;

import com.abdinurmuse.league.Models.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PlayerRepositoryTest {

    @Autowired
    PlayerRepository playerRepository;


    @Test
    void findbyteamid() {

        Player player = new Player(1, 1, "Abdinur", 26, 10, "SMALL_FORWARD", 0.0, 0.0, 0.0, 0.0);

        playerRepository.save(player);

        List<Player> players = playerRepository.findbyteamid(1);


        assertEquals(players.size(), 1);
        assertEquals(players.get(0), player);
    }
}