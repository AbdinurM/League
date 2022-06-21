package com.BBall.League.Service;


import com.BBall.League.Repository.PlayerRepository;
import com.BBall.League.Repository.TeamException;
import com.BBall.League.models.Player;
import com.BBall.League.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
   private PlayerRepository playerRepository;

    @Override
    public void addPlayer(Player newPlayer) throws TeamException {
       this.playerRepository.save(newPlayer);
    }

    @Override
    public List<Player> getAllPlayer() throws TeamException {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayer(int playerId) throws TeamException {
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
    public Player updatePlayer(Player updatePlayer) throws TeamException {
        return null;
    }

    @Override
    public void deletePlayerByplayerId(int playerId) throws TeamException {
        this.playerRepository.deleteById(playerId);
    }


}
