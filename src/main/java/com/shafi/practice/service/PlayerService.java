package com.shafi.practice.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shafi.practice.dtos.PlayerDto;
import com.shafi.practice.model.Player;
import com.shafi.practice.repositories.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;
	
	public void addPlayer(PlayerDto playerDto) {
		
		var playerEntity = new Player();
		
		BeanUtils.copyProperties(playerDto, playerEntity);
		
		playerRepository.save(playerEntity);
	}
	
	
}
