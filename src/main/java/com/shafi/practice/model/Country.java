package com.shafi.practice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "country")
public class Country implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	@Column(name = "id")
	public Long countryId;
	
	@Column(name = "isActive",updatable = true, nullable = false)
	
    private boolean isActive;
	
	@Column
	private String countryName;
	

	
	


	/**
	 * @param countryId
	 * @param isActive
	 * @param countryName
	 */
	public Country(Long countryId, boolean isActive, String countryName) {
		super();
		this.countryId = countryId;
		this.isActive = isActive;
		this.countryName = countryName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Country() {
		
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", isActive=" + isActive + ", countryName=" + countryName + "]";
	}












	
	
	

}
