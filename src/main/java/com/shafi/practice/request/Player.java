package com.shafi.practice.request;

import java.io.Serializable;


public class Player implements Serializable{

	private String firstName;

	private String lastName;

	private boolean isActive;

	private String dob;

	private String playingRole;

	private Long teamId;

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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPlayingRole() {
		return playingRole;
	}

	public void setPlayingRole(String playingRole) {
		this.playingRole = playingRole;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	@Override
	public String toString() {
		return "Player [firstName=" + firstName + ", lastName=" + lastName + ", isActive=" + isActive + ", dob=" + dob
				+ ", playingRole=" + playingRole + ", teamId=" + teamId + "]";
	}

	

	
}
