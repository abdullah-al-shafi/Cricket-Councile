package com.shafi.practice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shafi.practice.model.Manager;

@Repository
@Transactional
public interface ManagerRepository extends JpaRepository<Manager, Long>{

	Manager findBymanagerId(Long id);
	
	List<Manager> findByisActiveTrue();
	
	List<Manager> findByisActiveFalse();
	
	Manager findByuser_id(Long id);
	
	
}
