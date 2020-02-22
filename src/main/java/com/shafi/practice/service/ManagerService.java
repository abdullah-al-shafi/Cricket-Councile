package com.shafi.practice.service;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shafi.practice.dtos.ManagerDto;
import com.shafi.practice.model.Age;
import com.shafi.practice.model.Manager;
import com.shafi.practice.repositories.ManagerRepository;


@Service
public class ManagerService {
	
	@Autowired
	private ManagerRepository managerRepository;
	
	public void addManager(ManagerDto managerDto) {
		
		var managerEntity = new Manager();
		
		BeanUtils.copyProperties(managerDto, managerEntity);
		
		managerRepository.save(managerEntity);
	}
	
	public  List<Manager> getActiveAll(){
		
		return managerRepository.findByisActiveTrue();
	}
	
	public Manager managerById(Long id) {
		
		return managerRepository.findBymanagerId(id);
	}
	
	public Manager getManagerByUserID(Long id) {
		return managerRepository.findByuser_id(id);
	}
	
	
}
