package com.ght.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ght.model.Payments;
import com.ght.service.PaymentsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/payments")
public class PaymentsController {

	
	  @Autowired
	    private PaymentsService paymentsService;

	    @GetMapping
	    public List<Payments> getAllPayments() {
	        return paymentsService.getAllPayments();
	    }

	    @PostMapping
	    public Payments createPayments(@RequestBody Payments payments) {
	        return paymentsService.savePayments(payments);
	    }
	
}
