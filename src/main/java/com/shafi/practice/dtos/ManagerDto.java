package com.shafi.practice.dtos;

import java.io.Serializable;

import javax.persistence.Column;

import com.shafi.practice.model.Team;
import com.shafi.practice.model.User;

public class ManagerDto implements Serializable{
	
	private String dob;
	
	private String phone;
	
	private boolean isActive;
	
	private User user;
	
	private Team team;

	public ManagerDto() {
		
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "ManagerDto [dob=" + dob + ", phone=" + phone + ", user=" + user + ", team=" + team + "]";
	}
	
	

}
