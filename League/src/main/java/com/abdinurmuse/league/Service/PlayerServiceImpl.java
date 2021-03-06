package com.abdinurmuse.league.Service;


import com.abdinurmuse.league.Repository.PlayerRepository;
import com.abdinurmuse.league.Repository.LeagueException;
import com.abdinurmuse.league.Models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {
   @Autowired
   private PlayerRepository playerRepository;

    @Override
    public void addPlayer(Player newPlayer) throws LeagueException {
       this.playerRepository.save(newPlayer);
    }

    @Override
    public List<Player> getAllPlayer() throws LeagueException {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayer(int playerId) throws LeagueException {
        Optional<Player> optional = playerRepository.findById(playerId);
        Player player = null;
        if (optional.isPresent()) {
            player = optional.get();
        } else {
            throw new RuntimeException(" Sorry we can not locate the player you are looking for :: " + playerId);
        }
        return player;
    }


    @Override
    public Player updatePlayer(Player updatePlayer) throws LeagueException {
        return null;
    }

    @Override
    public void deletePlayerByplayerId(int playerId) throws LeagueException {
        this.playerRepository.deleteById(playerId);
    }

    @Override
   public List<Player> findbyteamid(int teamId) throws LeagueException {
        return playerRepository.findbyteamid(teamId);
    }
    }



