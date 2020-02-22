package com.shafi.practice.model;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.shafi.practice.model.Country;

@Entity
@Table(name = "team")
public class Team implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long teamId;
	@Column
	private String teamName;
	
	@Column(name = "isActive",updatable = true, nullable = false)
	private boolean isActive;
	
	@OneToOne (orphanRemoval=true)
	private Country country;

	public Team() {
		
	}



	public Team(Long teamId, String teamName, boolean isActive, Country country) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.isActive = isActive;
		this.country = country;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



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

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", isActive=" + isActive + ", country=" + country
				+ "]";
	}
	
	
	

	
	
	
	
	
	
}
