package com.shafi.practice.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shafi.practice.enums.Role;
import com.shafi.practice.model.Manager;
import com.shafi.practice.model.User;
import com.shafi.practice.repositories.UserRepository;
import com.shafi.practice.service.ManagerService;
import com.shafi.practice.service.UserService;


@Controller
public class UserController {
	

	@Autowired
	UserService userService;
	
	@Autowired
	ManagerService managerService;
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/")
	public String root(Model model , Authentication auth) {
		
		var username =  auth.getName();
		
		User user = userService.getUserByName(username);
		
		Manager manager = managerService.getManagerByUserID(user.getId());
		
		model.addAttribute("manager",manager);
		model.addAttribute("role",user.getRole());
		return "index";
	}
	
	@GetMapping("/403")
	public String _403() {
		return "403";
	}
	
	@GetMapping("/login")
	public String login(Model model, @RequestParam(name="error", required = false) String error) {
		generateUsers();
		model.addAttribute("error", error);
		return "login";
	}

	private void generateUsers() {

		if (userRepository.findByUsername("admin").isEmpty()) {
			var user = new User();
			user.setUsername("admin");
			user.setPassword(passwordEncoder.encode("admin"));
			user.setRole(Role.ROLE_ADMIN);
			userRepository.save(user);
		}

	}
}
