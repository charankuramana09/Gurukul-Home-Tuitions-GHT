package com.ght.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ght.model.Parent;
import com.ght.service.ParentService;

@RestController
@RequestMapping("/api/parents")
@CrossOrigin(origins = "*")
public class ParentController {
	@Autowired
    private ParentService parentService;

    @PostMapping("/register")
    public Parent registerParent(@RequestBody Parent parent) {
        return parentService.registerParent(parent);
    }
}
