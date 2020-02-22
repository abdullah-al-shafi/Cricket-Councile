package com.shafi.practice.repositories;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shafi.practice.dtos.TeamDto;
import com.shafi.practice.model.Country;
import com.shafi.practice.model.Team;

@Repository
@Transactional
public interface TeamRepository extends JpaRepository<Team, Long>{

	Team findByteamId(Long id);
	
	Team findByteamName(String teamName);
	
	List<Team> findByisActiveTrue();
	
	Team findByisActive(Boolean boolean1);
	
	Team findBycountry_countryId(long id);
	
}
