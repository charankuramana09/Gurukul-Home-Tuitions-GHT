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

    // New query to find tutors by subject expertise
    @Query("SELECT t FROM TutorDetails t WHERE LOWER(t.expertInClass) LIKE %:subject%")
    List<TutorDetails> findTutorsBySubject(@Param("subject") String subject);
    
    @Query("SELECT t FROM TutorDetails t WHERE t.expertInClass LIKE %:subject%")
    List<TutorDetails> findBySubject(@Param("subject") String subject);

}
