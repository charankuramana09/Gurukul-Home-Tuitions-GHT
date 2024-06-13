package com.ght.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ght.model.Parent;
import com.ght.repository.ParentRepository;

@Service
public class ParentService {
	  @Autowired
	    private ParentRepository parentRepository;

	    public Parent registerParent(Parent parent) {
	        return parentRepository.save(parent);
	    }
}
