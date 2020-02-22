package com.shafi.practice.request;

import java.io.Serializable;

public class Team implements Serializable{
	
	private String teamName;
	
	private Long countryId;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Team() {
		
	}
	
	

	@Override
	public String toString() {
		return "Team [teamName=" + teamName + ", countryId=" + countryId + "]";
	}

	
	

}
