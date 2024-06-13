package com.ght.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ght.model.ArrangeSeat;
import com.ght.serviceInterface.ArrangeSeatService;

@RestController
@RequestMapping("/api/seat")
@CrossOrigin(origins = "*") 
public class ArrangeSeatController {

	@Autowired
	private ArrangeSeatService arrangeSeatService;
	
	@PostMapping("/save")
	public ArrangeSeat bookSeat(@RequestBody ArrangeSeat arrangeSeat) {
		return arrangeSeatService.saveRegistration(arrangeSeat);
	}
}
