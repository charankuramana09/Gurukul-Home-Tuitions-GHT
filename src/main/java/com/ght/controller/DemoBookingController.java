package com.ght.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ght.model.DemoBooking;
import com.ght.service.DemoBookingService;

@RestController
@RequestMapping("/api/demo-booking")
@CrossOrigin(origins = "*")
public class DemoBookingController {
	 @Autowired
	    private DemoBookingService demoBookingService;

	    @PostMapping("/book")
	    public ResponseEntity<DemoBooking> bookDemo(@RequestBody DemoBooking demoBooking) {
	        DemoBooking savedBooking = demoBookingService.saveBooking(demoBooking);
	        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
	    }
}
