package com.shafi.practice.repositories;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shafi.practice.model.Player;



@Repository
@Transactional
public interface PlayerRepository extends JpaRepository<Player, Long>{

	List<Player> findByisActiveTrue();
	
	@Query(value = "select *" +
			" from players p" +
			" where p.firstName like %:keyword% " +
			"or c.lastName like %:keyword%", nativeQuery = true)
	List<Player> getPlayersByQueryString(@Param("keyword") String query);
	
//	List<Player> findByisActiveTrueAndteam_teamId(Long id);
}
