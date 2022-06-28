package com.abdinurmuse.league.Service;

import com.abdinurmuse.league.Repository.LeagueException;
import com.abdinurmuse.league.Models.Player;

import java.util.List;

public interface PlayerService {
    void addPlayer(Player newPlayer) throws LeagueException;//add player to db

    List<Player> getAllPlayer() throws LeagueException;//get all player in db

    Player getPlayer(int playerId) throws LeagueException;//returns a player by ID

    Player updatePlayer(Player updatePlayer) throws LeagueException;//update Player

    void deletePlayerByplayerId(int playerId) throws LeagueException;//delete player by id

    List<Player> findbyteamid(int teamId) throws LeagueException;

}
