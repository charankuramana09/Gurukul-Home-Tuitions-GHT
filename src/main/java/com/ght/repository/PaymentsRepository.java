package com.ght.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ght.model.Payments;

@Repository
public interface PaymentsRepository  extends  JpaRepository<Payments, Long> {

}
