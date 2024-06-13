package com.ght.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ght.model.Payments;
import com.ght.repository.PaymentsRepository;

@Service
public class PaymentsService {
	
	
    @Autowired
    private PaymentsRepository paymentsRepository;

    public List<Payments> getAllPayments() {
        return paymentsRepository.findAll();
    }

    public Payments savePayments(Payments payments) {
        return paymentsRepository.save(payments);
    }


}
