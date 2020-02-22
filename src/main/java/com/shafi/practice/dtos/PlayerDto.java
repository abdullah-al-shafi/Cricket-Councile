package com.shafi.practice.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import com.shafi.practice.model.Team;
import com.shafi.practice.model.User;

public class PlayerDto implements Serializable{

	private String firstName;

	private String lastName;

	private boolean isActive;

	private Date dob;

	private String playingRole;

	private Team team;

	private User user;

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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date localDate) {
		this.dob = localDate;
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


	@Override
	public String toString() {
		return "PlayerDto [firstName=" + firstName + ", lastName=" + lastName + ", isActive=" + isActive + ", dob="
				+ dob + ", playingRole=" + playingRole + ", team=" + team + ", user=" + user + "]";
	}
	
	
}
