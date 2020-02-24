package com.shafi.practice.dtos;

import java.io.Serializable;

import com.shafi.practice.model.Country;

public class TeamDto implements Serializable{
	
	private Long teamId;
	
	private String teamName;
	
	private Country country;

	private boolean isActive;
	
	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * 
	 */
	public TeamDto() {
		
	}

	@Override
	public String toString() {
		return "TeamDto [teamId=" + teamId + ", teamName=" + teamName + ", country=" + country + ", isActive="
				+ isActive + "]";
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public TeamDto(Long teamId, String teamName, Country country, boolean isActive) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.country = country;
		this.isActive = isActive;
	}
	
	












	
	

}
