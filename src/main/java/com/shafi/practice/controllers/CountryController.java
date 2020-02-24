package com.shafi.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shafi.practice.model.Country;
import com.shafi.practice.service.CountryService;


@Controller
public class CountryController {

	
	@Autowired 
	CountryService countryService;
	
	@GetMapping("/country/add")
	public String addCountry_GET(Model model) {
		model.addAttribute("pageTitle", "Add Country");
		model.addAttribute("country", new Country());
		model.addAttribute("message", "Please add a country");
		return "country/add";
	}

	@PostMapping("/country/add")
	public String addCountry(Model model, @ModelAttribute(name = "country") Country country) {
		
		Country count = new Country();
		count.setActive(true);
		count.setCountryName(country.getCountryName());
		countryService.addCountry(count);
//		model.addAttribute("message", "Country added successfully");
		return "redirect:/country/show-all";
	}

	@GetMapping("/country/show-all")
	public String showAll_GET(Model model) {
		model.addAttribute("pageTitle", "Country List");
		model.addAttribute("countries", countryService.getAllCountrys());
		model.addAttribute("message", "Showing all countries");
		return "country/show";
	}
	
	@GetMapping("/country/inactive")
	public String showAllInActive(Model model) {
		model.addAttribute("pageTitle", "InActive Country List");
		model.addAttribute("countries", countryService.getAllDeleteCountrys());
		model.addAttribute("message", "Showing all InActive countries");
		return "country/inactive";
	}
	
	@GetMapping("/country/edit")
	public String editCountryByCountryID(Model model, @RequestParam("countryId") long countryId) {

		Country country = countryService.countryByID(countryId);
		model.addAttribute("country", country);
		// model.addAttribute("course", new Course());
		return "country/edit";
	}
	
	@PostMapping("/country/edit")
	public String saveEditedCountry(Model model, @ModelAttribute(name = "country") Country country) {
		countryService.saveEditedCountry(country);
		model.addAttribute("message", "country saved successfully");

		return "redirect:/country/show-all";
	}
	
	@GetMapping("/country/delete")
	public String deletCountryByCountryID( @RequestParam("countryId") long countryId) {
		countryService.delete(countryId);
		return "redirect:/country/show-all";
	}
	
	@GetMapping("/country/active")
	public String activeCountryByCountryID( @RequestParam("countryId") long countryId) {
		countryService.active(countryId);
		return "redirect:/country/inactive";
	}
	
}
