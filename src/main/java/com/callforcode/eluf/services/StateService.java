package com.callforcode.eluf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callforcode.eluf.model.State;
import com.callforcode.eluf.repositories.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository repo;	
	
	public List<State> findAll() {
		return repo.findAllByOrderByName();
		
	}

}