/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdinurmuse.league.Repository;

/**
 * @author Nur
 */

import com.abdinurmuse.league.Models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository <Player, Integer>{
  @Query("Select p from Player p where team_id =?1")
    List<Player> findbyteamid(int teamId);
}
//queries


