package com.shafi.practice.repositories;


import java.util.List;
import java.util.Optional;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shafi.practice.model.Country;



@Repository
@Transactional
public interface CountryRepository extends JpaRepository<Country, Long>{

	Country findBycountryId(Long id);
	
	List<Country> findByisActiveTrue();
	
	List<Country> findByisActiveFalse();
	
	Country findBycountryName(String countryName);
	
}
