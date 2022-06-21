/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BBall.League.models;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Nur
 */
@Entity
@Table(name = "Team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int teamId;
    @Column(name = "Teamname")
    private String name;
    @Column(name = "Teamcolor")
    private String color;
    @Column(name = "Teamwins")
    private int Wins;
    @Column(name = "Teamlose")
    private int Lose;
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Team_Player",
            joinColumns = @JoinColumn(
                    name = "teamid", referencedColumnName = "teamid"),
            inverseJoinColumns = @JoinColumn(
                    name = "name", referencedColumnName = "name"))
    private Collection <Player> player;

    public Team() {

    }

    public Team(int teamId, String name, String color, int Wins, int Lose) {
        this();
        this.teamId = teamId;
        this.name = name;
        this.color = color;
        this.Wins = Wins;
        this.Lose = Lose;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWins() {
        return Wins;
    }

    public void setWins(int wins) {
        Wins = wins;
    }

    public int getLose() {
        return Lose;
    }

    public void setLose(int lose) {
        Lose = lose;
    }

 //   public Collection<Player> getPlayer() {
        //return player;
 //   }

  //  public void setPlayer(Collection<Player> player) {
     //   this.player = player;
  //  }
}