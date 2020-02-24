package com.shafi.practice.service;

import java.util.ArrayList;
import java.util.List;

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
	
//	public List<Player> getAllPlayerByTeam(Long id){
//		
//		return playerRepository.findByisActiveTrueAndteam_teamId(id);
//	}
	
	public List<Player> getAllPlayer(){
		
		return playerRepository.findByisActiveTrue();
	}
	
	public List<Player> searchPlayer(String query){
		var players = this.playerRepository.getPlayersByQueryString(query);
		var playerDtos = new ArrayList<Player>();
		for (var player : players) {
			var playerDto = new Player();
			BeanUtils.copyProperties(players, playerDto);
			playerDtos.add(playerDto);
		}
		return playerDtos;
	}
}
