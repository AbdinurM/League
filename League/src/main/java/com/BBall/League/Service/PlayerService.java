package com.BBall.League.Service;

import com.BBall.League.Repository.TeamException;
import com.BBall.League.models.Player;

import java.util.List;

public interface PlayerService {
    void addPlayer(Player newPlayer) throws TeamException;

    List<Player> getAllPlayer() throws TeamException;

    Player getPlayer(int playerId) throws TeamException;

    Player updatePlayer(Player updatePlayer) throws TeamException;

    void deletePlayerByplayerId(int playerId) throws TeamException;

}
