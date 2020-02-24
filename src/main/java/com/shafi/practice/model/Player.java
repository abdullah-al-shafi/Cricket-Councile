package com.shafi.practice.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "players")
public class Player implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long palyerId;
	
	@Column(name = "firstname",updatable = false, nullable = false )
	private String firstName;

	@Column(name = "lastname",updatable = false )
	private String lastName;
	
	@Column(name = "isActive",updatable = true, nullable = false)
	private boolean isActive;
	
	@Column(name = "dob",updatable = false)
	private Date dob;
	
	@Column(name = "playingroll",updatable = true )
	private String playingRole;
	
	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
	private User user;

	public Long getPalyerId() {
		return palyerId;
	}

	public void setPalyerId(Long palyerId) {
		this.palyerId = palyerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPlayingRole() {
		return playingRole;
	}

	public void setPlayingRole(String playingRole) {
		this.playingRole = playingRole;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Player(Long palyerId, String firstName, String lastName, boolean isActive, Date dob, String playingRole,
			Team team, User user) {
		super();
		this.palyerId = palyerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isActive = isActive;
		this.dob = dob;
		this.playingRole = playingRole;
		this.team = team;
		this.user = user;
	}

	public Player() {
		
	}

	@Override
	public String toString() {
		return "Player [palyerId=" + palyerId + ", firstName=" + firstName + ", lastName=" + lastName + ", isActive="
				+ isActive + ", dob=" + dob + ", playingRole=" + playingRole + ", team=" + team + ", user=" + user
				+ "]";
	}


	
	
	
}
