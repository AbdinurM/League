/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BBall.League.Repository;


import com.BBall.League.models.Player;
import com.BBall.League.models.Team;
import com.BBall.League.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Nur
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
   // @Query("SELECT t FROM team t WHERE t.teamId = ?1")
    //public User findByTeamplayer(String teamId);
}

