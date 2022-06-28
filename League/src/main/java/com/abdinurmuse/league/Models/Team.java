/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdinurmuse.league.Models;

import javax.persistence.*;
import java.util.*;

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
    //creates columns

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "teamId",
            insertable = false, updatable = false)

    private List<Player> teamplayer = new ArrayList<>();

    public Team() {

    }

    public Team(int teamId, String name, String color, int Wins, int Lose) {
        this();
        this.teamId = teamId;
        this.name = name;
        this.color = color;
        this.Wins = Wins;
        this.Lose = Lose;
    }//assiging var

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
//setters and getters


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return teamId == team.teamId && Wins == team.Wins && Lose == team.Lose && Objects.equals(name, team.name) && Objects.equals(color, team.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, name, color, Wins, Lose);
    }
}