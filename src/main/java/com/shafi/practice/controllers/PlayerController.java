package com.shafi.practice.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shafi.practice.dtos.PlayerDto;
import com.shafi.practice.enums.Role;
import com.shafi.practice.model.User;
import com.shafi.practice.request.Manager;
import com.shafi.practice.request.Player;
import com.shafi.practice.service.ManagerService;
import com.shafi.practice.service.PlayerService;
import com.shafi.practice.service.TeamService;
import com.shafi.practice.service.UserService;

@Controller
public class PlayerController {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	PlayerService playerService;

	@Autowired
	TeamService teamService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ManagerService managerService;

	@GetMapping("/player/add")
	public String getPlayerAddPage(Model model) {
		Player player = new Player();
		model.addAttribute("player", player);
		var playingRole = new HashMap<String, String>();
		playingRole.put("Batsman", "Batsman");
		playingRole.put("Bowler", "Bowler");
		playingRole.put("Allrounder", "Allrounder");
		model.addAttribute("playingRole_list", playingRole);
		return "player/add";
	}
	
	@PostMapping("/player/add")
	public String addPlayerPage(@ModelAttribute("player")Player player,Model model,Authentication auth) throws ParseException {
		SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
		Date date1=formatter1.parse(player.getDob());
		var username =  auth.getName();
		User currentUser = userService.getUserByName(username);
		com.shafi.practice.model.Manager manager = managerService.getManagerByUserID(currentUser.getId());
		var team = teamService.getTeamByID(manager.getTeam().getTeamId());
		User user = new User();
		user.setUsername(player.getFirstName());
		user.setRole(Role.ROLE_PLAYER);
		user.setPassword(passwordEncoder.encode("player"));
		PlayerDto playerDto = new PlayerDto();
		BeanUtils.copyProperties(player, playerDto);
		playerDto.setActive(true);
		playerDto.setTeam(team);
		playerDto.setDob(date1);
		playerDto.setUser(user);
		playerService.addPlayer(playerDto);
		return "redirect:/player/add";
	}
	
	@GetMapping("/player/show-all")
	public String allPlayerShowPage(Model model) {
		model.addAttribute("pageTitle", "Player List");
		model.addAttribute("player_list", playerService.getAllPlayer());
		return "player/show";
	}
	
	@GetMapping(value = "/search-page")
	public String searchPlayerView(Model model) {
		return "/player/search";
	}
}
