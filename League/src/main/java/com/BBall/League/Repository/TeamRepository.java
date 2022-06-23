/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AbdinurMuse.League.Repository;


import com.AbdinurMuse.League.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nur
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
 //  @Query("Select t.teamplayer  from Team t where teamId =?1")
   // List<Player> findbyteamid(int teamId);
}
//queries
