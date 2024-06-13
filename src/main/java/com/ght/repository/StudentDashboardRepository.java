package com.ght.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ght.model.StudentDashboard;


@Repository
public interface StudentDashboardRepository  extends JpaRepository<StudentDashboard, Long> {

}
