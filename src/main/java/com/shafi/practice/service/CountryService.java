package com.shafi.practice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Transaction;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.shafi.practice.config.persistence.HibernateConfig;
import com.shafi.practice.exceptions.ResourceAlreadyExistsException;
import com.shafi.practice.model.Country;
import com.shafi.practice.repositories.CountryRepository;

@Service
public class CountryService {

	private final HibernateConfig hibernateConfig;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	public CountryService(HibernateConfig hibernateConfig) {

		this.hibernateConfig = hibernateConfig;
	}

	public Country countryByID(Long id) {
		return countryRepository.findBycountryId(id);
	}

	public void saveEditedCountry(Country c) {

		var country = countryRepository.findBycountryId(c.getCountryId());

		BeanUtils.copyProperties(c, country);

		countryRepository.save(country);
	}

	public void addCountry(Country country) {

		checkCountryInList(country);
		countryRepository.save(country);

	}

	public void checkCountryInList(Country c) {
		var country = countryRepository.findBycountryName(c.getCountryName());
		if (country != null) {
			throw new ResourceAlreadyExistsException("Country Already exists");
		}
	}

	public List<Country> getAllCountrys() {

//		var countryList = new ArrayList<Country>();
//		
//		countryRepository.findAll().forEach(country -> {
//
//			var countryNew = new Country();
//
//			if (country.isActive() != false ) {
//				BeanUtils.copyProperties(country, countryNew);
//			}
//			else {
//				return ;
//			}
//
//			countryList.add(countryNew);
//
//		});
////		return countryList;
		
		return countryRepository.findByisActiveTrue();

	}
	
	public List<Country> getAllDeleteCountrys() {
		
		return countryRepository.findByisActiveFalse();

	}

	public void delete(long id) {
		var country = countryRepository.findBycountryId(id);
		country.setActive(false);
		countryRepository.save(country);
	}
	public void active(long id) {
		var country = countryRepository.findBycountryId(id);
		country.setActive(true);
		countryRepository.save(country);
	}

}
