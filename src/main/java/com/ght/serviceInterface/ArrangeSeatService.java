package com.ght.serviceInterface;

import java.util.List;

import com.ght.model.ArrangeSeat;

public interface ArrangeSeatService {
	
	ArrangeSeat saveRegistration(ArrangeSeat arrangeSeat);
	
	  public List<Object[]> countBySubject(String tutorName);
	  
	 public Long countStudentsBySubject(String subject);	
}
