package com.shafi.practice.controllers;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shafi.practice.dtos.ManagerDto;

import com.shafi.practice.enums.Role;

import com.shafi.practice.model.User;
import com.shafi.practice.request.Manager;
import com.shafi.practice.service.ManagerService;
import com.shafi.practice.service.TeamService;

@Controller
public class ManagerController {

	@Autowired
	TeamService teamService;
	
	@Autowired
	ManagerService managerService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
    @GetMapping("/manager/add")
    public String getManagerAddPage(Model model){
        model.addAttribute("manager", new Manager());
        model.addAttribute("team_list",teamService.showAll());
        return "manager/add";
    }
    
	@PostMapping("/manager/add")
	public String Add(@ModelAttribute("manager")Manager manager,Model model) {
		
		var team = teamService.getTeamByID(manager.getTeamId());
		
		User user = new User();
		user.setUsername(manager.getName());
		user.setRole(Role.ROLE_MANAGER);
		user.setPassword(passwordEncoder.encode("manager"));
		var managerDto = new ManagerDto();
		BeanUtils.copyProperties(manager, managerDto);
		managerDto.setActive(true);
		managerDto.setTeam(team);
		managerDto.setUser(user);
		managerService.addManager(managerDto);
		return "redirect:/manager/add"; 
	}
	
    @GetMapping("/manager/show-all")
    public String showAllManagerPage(Model model){
        model.addAttribute("manager_list",managerService.getActiveAll());
        return "manager/show";
    }
    
    @GetMapping("/manager/details")
    public String showManagerDetails(Model model,@RequestParam("managerId") long managerId){
    	
    	com.shafi.practice.model.Manager manager = managerService.managerById(managerId);
        model.addAttribute("manager",manager);
        return "manager/details";
    }
    
}
