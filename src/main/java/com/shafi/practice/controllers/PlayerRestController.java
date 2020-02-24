package com.shafi.practice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shafi.practice.service.PlayerService;

@RestController
@RequestMapping("/api/v1")
public class PlayerRestController {

	private final PlayerService playerService ;
	
	public PlayerRestController(PlayerService playerService) {
		this.playerService = playerService;
	}
	
	@GetMapping(value = "/player/search")
    public ResponseEntity<?> searchPlayerByName(@RequestParam(name = "query") String query) {
        var data = playerService.searchPlayer(query);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
