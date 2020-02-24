package com.shafi.practice.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shafi.practice.dtos.TeamDto;
import com.shafi.practice.request.Team;
import com.shafi.practice.service.CountryService;
import com.shafi.practice.service.TeamService;

@Controller
public class TeamController {
	
	@Autowired
	private TeamService teamService;

	@Autowired
	private CountryService countryService;
	
	@GetMapping("team/add")
	public String Add(Model model) {
		model.addAttribute("pageTitle", "Add Team");
		model.addAttribute("team",new Team());
		model.addAttribute("countries",countryService.getAllCountrys());
		return "team/add";
	}
	
	@PostMapping("team/add")
	public String Add(@ModelAttribute("team")Team team,Model model) {
		var country = countryService.countryByID(team.getCountryId());
		var teamDto = new TeamDto();
		BeanUtils.copyProperties(team, teamDto);
		teamDto.setCountry(country);
		teamDto.setActive(true);
		teamService.addTeam(teamDto);
		return "redirect:/team/show";
	}
	
	@GetMapping("team/show")
	public String showTeam(Model model) {
		model.addAttribute("pageTitel","showAll Team");
		model.addAttribute("team_list",teamService.showAll());
		model.addAttribute("message", "Showing all countries");
		return "team/show";
	}
	
	@GetMapping("/team/delete")
	public String deletTeamByTeamID( @RequestParam("teamId") long teamId) {
		teamService.delete(teamId);
		return "redirect:/team/show";
	}
	
	
}
