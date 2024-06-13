package com.ght.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ght.model.DemoBooking;
import com.ght.repository.DemoBookingRepository;

@Service
public class DemoBookingService {
	@Autowired
    private DemoBookingRepository demoBookingRepository;

    public DemoBooking saveBooking(DemoBooking demoBooking) {
        return demoBookingRepository.save(demoBooking);
    }
}
