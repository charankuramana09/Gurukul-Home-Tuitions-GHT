package com.ght.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	  @GetMapping("/countBySubject")
	  public List<Object[]> countBySubject(@RequestParam String tutorName) {
	        return arrangeSeatService.countBySubject(tutorName);
	   } 
	  
	  
	  @GetMapping("/countBySubject/std")
	  public List<Object[]> countBySubjectStd(@RequestParam String name) {
		  return arrangeSeatService.countBySubjectStd(name);
	  }
	  	
	  
	   @GetMapping("/count/{subject}")
	    public ResponseEntity<Long> countStudentsBySubject(@PathVariable("subject") String subject) {
	        Long count = arrangeSeatService.countStudentsBySubject(subject);
	        return ResponseEntity.ok(count);
	    }
	   
}
