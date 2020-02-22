package com.shafi.practice.request;

import java.io.Serializable;

public class Manager implements Serializable{

	private String name;
	
	private String dob;
	
	private String phone;
	
	private Long teamId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	@Override
	public String toString() {
		return "Manager [name=" + name + ", dob=" + dob + ", phone=" + phone + ", teamId=" + teamId + "]";
	}

	public Manager(String name, String dob, String phone, Long teamId) {
		super();
		this.name = name;
		this.dob = dob;
		this.phone = phone;
		this.teamId = teamId;
	}

	public Manager() {
		
	}
	
	
}
