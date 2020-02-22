package com.shafi.practice.repositories;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shafi.practice.model.Player;


@Repository
@Transactional
public interface PlayerRepository extends JpaRepository<Player, Long>{

	List<Player> findByisActiveTrue();
}
