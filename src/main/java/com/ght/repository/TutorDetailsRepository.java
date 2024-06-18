package com.ght.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ght.model.PersonalDetails;
import com.ght.model.TutorDetails;

public interface TutorDetailsRepository extends JpaRepository<TutorDetails, Long> {

    @Query("SELECT t FROM TutorDetails t WHERE t.personalDetails = :personalDetails")
    Optional<TutorDetails> findByPersonalDetails(@Param("personalDetails") PersonalDetails personalDetails);

    @Query("SELECT t.personalDetails.name, t.personalDetails.email, t.expertInClass, t.image FROM TutorDetails t")
    List<Object[]> findTutors();

     
    @Query("SELECT t FROM PersonalDetails p INNER JOIN TutorDetails t ON p.id = t.id " +
    "WHERE p.email = :email")
List findByPersonalDetails(@Param("email") String email);  

@Query("SELECT p.email, p.name, t.image, t.expertInClass FROM PersonalDetails p INNER JOIN TutorDetails t ON p.id = t.id WHERE p.email = :email")
List findByPersonalDetailsdashboard(@Param("email") String email);  


}
