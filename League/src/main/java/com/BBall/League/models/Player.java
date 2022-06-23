/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AbdinurMuse.League.models;

import javax.persistence.*;

/**
 *
 * @author Nur
 */
@Entity
@Table(name = "Player")//table name
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;

	@Column(name = "teamId")
	private int teamId;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//@JoinTable(
	//      name = "Team_Player",
	//    joinColumns = @JoinColumn(
	//          name = "teamid", referencedColumnName = "teamid"),
	// inverseJoinColumns = @JoinColumn(
	//       name = "name", referencedColumnName = "name"))
	private Team team;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	@Column(name = "jeserynumber")
	private int jeserynumber;
	@Column(name = "Position")
	private String Position;

	@Column(name = "PPG")
	private Double PPG;
	@Column(name = "RPG")
	private Double RPG;
	@Column(name = "APG")
	private Double APG;
	@Column(name = "BPG")
	private Double BPG;
//creates columns



public Player() {

}
public Player(int playerId,int teamId,String name,int age,int jeserynumber,String Position, Double PPG,Double RPG,Double APG,Double BPG) {
	this();
	this.playerId = playerId;
	this.teamId = teamId;
	this.name = name;
	this.age = age;
	this.jeserynumber = jeserynumber;
	this.Position = Position;
	this.PPG = PPG;
	this.RPG = RPG;
	this.APG = APG;
	this.BPG = BPG;
}//asssigning var

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getJeserynumber() {
		return jeserynumber;
	}

	public void setJeserynumber(int jeserynumber) {
		this.jeserynumber = jeserynumber;
	}

	public String getPosition() {
		return Position;
	}

	public void setPosition(String position) {
		Position = position;
	}

	public Double getPPG() {
		return PPG;
	}

	public void setPPG(Double PPG) {
		this.PPG = PPG;
	}

	public Double getRPG() {
		return RPG;
	}

	public void setRPG(Double RPG) {
		this.RPG = RPG;
	}

	public Double getAPG() {
		return APG;
	}

	public void setAPG(Double APG) {
		this.APG = APG;
	}

	public Double getBPG() {
		return BPG;
	}

	public void setBPG(Double BPG) {
		this.BPG = BPG;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	//setters and getters
}
