package com.ght.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ght.model.StudentDashboard;
import com.ght.service.StudentDashboardService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/studentdashboard")
public class StudentDashboardController {
	
	 @Autowired
	    private StudentDashboardService studentDashboardService;

	    @GetMapping()
	    public List<StudentDashboard> getAllStudents() {
	        return studentDashboardService.getAllStudents();
	    }

	    @PostMapping("/save")
	    public StudentDashboard createStudent(@RequestBody StudentDashboard studentDashboard) {
	        return studentDashboardService.saveStudent(studentDashboard);
	    }

}
