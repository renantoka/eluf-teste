package com.callforcode.eluf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callforcode.eluf.model.City;
import com.callforcode.eluf.repositories.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository repo;	
	
	public List<City> findByState(Integer stateId) {
		return repo.findCities(stateId);
	}

}