package com.shafi.practice.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "managers")
public class Manager implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",updatable = false, nullable = false)
    private long managerId;
	
	@Column(name = "dob",updatable = true, nullable = false)
    private String dob;
	
	@Column(name = "phone",updatable = true, nullable = false)
    private String phone;
	
	@Column(name = "isActive",updatable = true, nullable = false)
	private boolean isActive;
	
	@ManyToOne
    @JoinColumn(name = "team_id")
	private Team team;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
	private User user;

	public long getManagerId() {
		return managerId;
	}

	public void setManagerId(long managerId) {
		this.managerId = managerId;
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

	
	
	/**
	 * @param managerId
	 * @param dob
	 * @param phone
	 * @param isActive
	 * @param team
	 * @param user
	 */
	public Manager(long managerId, String dob, String phone, boolean isActive, Team team, User user) {
		super();
		this.managerId = managerId;
		this.dob = dob;
		this.phone = phone;
		this.isActive = isActive;
		this.team = team;
		this.user = user;
	}
	

	public Manager() {
		
	}

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", dob=" + dob + ", phone=" + phone + ", isActive=" + isActive
				+ ", team=" + team + ", user=" + user + "]";
	}
	
	
}
