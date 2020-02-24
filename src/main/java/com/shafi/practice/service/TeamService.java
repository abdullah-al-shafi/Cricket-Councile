package com.shafi.practice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shafi.practice.config.persistence.HibernateConfig;
import com.shafi.practice.dtos.TeamDto;
import com.shafi.practice.exceptions.ResourceAlreadyExistsException;
import com.shafi.practice.model.Country;
import com.shafi.practice.model.Team;
import com.shafi.practice.repositories.TeamRepository;
import com.sun.jdi.request.DuplicateRequestException;



@Service
public class TeamService {
	
	private final HibernateConfig hibernateConfig;
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	public TeamService(HibernateConfig hibernateConfig) {
		
		this.hibernateConfig = hibernateConfig;
	}
	
	
	public void addTeam(TeamDto teamDto) {
		
		checkTeamInList(teamDto);
		
		var country = countryService.countryByID(teamDto.getCountry().getCountryId());
		var teamEntity = new Team();
		BeanUtils.copyProperties(teamDto, teamEntity);
		
		teamEntity.setCountry(country);

		teamRepository.save(teamEntity);

	}

	private void checkTeamInList(TeamDto t) {
		
		var teamName = teamRepository.findByteamName(t.getTeamName());
		
		
		var country = teamRepository.findBycountry_countryId(t.getCountry().countryId);
	
		if (teamName != null) {
			throw new ResourceAlreadyExistsException("Team Already exists");
		}
		if(country != null) {
			throw new DuplicateRequestException("One Country Only add One Team");
		}
		
	}
	
	public Team getTeamByID(long teamID) {
		
		return teamRepository.findByteamId(teamID);
	}
	
	public List<Team> showAll() {
		
		return teamRepository.findByisActiveTrue();
	}


	public void delete(long teamId) {
		var team = teamRepository.findByteamId(teamId);
		team.setActive(false);
		teamRepository.save(team);
		
	}


	
}
