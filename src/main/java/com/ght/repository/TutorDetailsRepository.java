package com.ght.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ght.model.TutorDetails;

public interface TutorDetailsRepository extends JpaRepository<TutorDetails, Long> {

    @Query("SELECT t.name, t.email, t.expertInClass, t.image FROM TutorDetails t")
    List<Object[]> findTutors();

    @Query("SELECT t FROM TutorDetails t WHERE LOWER(t.expertInClass) LIKE %:subject%")
    List<TutorDetails> findTutorsBySubject(@Param("subject") String subject);

    @Query("SELECT t FROM TutorDetails t WHERE t.expertInClass LIKE %:subject%")
    List<TutorDetails> findBySubject(@Param("subject") String subject);

    @Query("SELECT t FROM TutorDetails t WHERE t.email = :email")
    Optional<TutorDetails> findByEmail(@Param("email") String email);

    @Query("SELECT t.email, t.name, t.image, t.expertInClass FROM TutorDetails t WHERE t.email = :email")
    List<Object[]> findByPersonalDetailsDashboard(@Param("email") String email);
}
