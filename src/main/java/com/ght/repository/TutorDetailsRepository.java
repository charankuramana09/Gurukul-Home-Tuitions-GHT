package com.ght.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ght.model.TutorDetails;

public interface TutorDetailsRepository extends JpaRepository<TutorDetails, Long>
{
	 @Query("SELECT u.name, u.email, t.expertInClass, t.image " +
	           "FROM TutorDetails t JOIN PersonalDetails u ON t.id = u.id")
	    List<Object[]> findTutors();
}
