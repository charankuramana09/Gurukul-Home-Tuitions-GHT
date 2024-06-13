package com.ght.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ght.model.ArrangeSeat;
import com.ght.repository.ArrangeSeatRepo;
import com.ght.serviceInterface.ArrangeSeatService;

@Service
public class ArrangeSeatServiceImpl implements ArrangeSeatService{

	@Autowired
	private  ArrangeSeatRepo arrangeSeatRepo;
	
	@Override
	public ArrangeSeat saveRegistration(ArrangeSeat arrangeSeat) {
		return arrangeSeatRepo.save(arrangeSeat);
	}

}
