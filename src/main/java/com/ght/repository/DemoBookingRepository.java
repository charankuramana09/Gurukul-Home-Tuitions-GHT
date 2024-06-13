package com.ght.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ght.model.DemoBooking;

public interface DemoBookingRepository extends JpaRepository<DemoBooking, Long>{

}
