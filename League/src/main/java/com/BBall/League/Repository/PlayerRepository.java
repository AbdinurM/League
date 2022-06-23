/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AbdinurMuse.League.Repository;

/**
 * @author Nur
 */

import com.AbdinurMuse.League.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository <Player, Integer>{
 // @Query("Select p.teamplayer  from Player p where teamteamid =?1")
   //  List<Player> findbyteamid(int teamId);
}
//queries


