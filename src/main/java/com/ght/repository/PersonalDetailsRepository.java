package com.ght.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ght.model.PersonalDetails;
import com.ght.model.Student;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long>{
	

    @Query("SELECT p FROM PersonalDetails p WHERE p.email = :email")
   public PersonalDetails findByEmail(@Param("email") String email);
    

}
