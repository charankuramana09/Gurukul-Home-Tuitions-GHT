package com.ght.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ght.model.ArrangeSeat;

public interface ArrangeSeatRepo extends JpaRepository<ArrangeSeat, Long>{
    


    @Query("SELECT a.name, a.subject,a.email, COUNT(*) FROM ArrangeSeat a WHERE a.tutor = :tutor GROUP BY a.name,a.subject,a.email")
    List<Object[]> countBySubject(@Param("tutor") String tutor);
    

    @Query("SELECT COUNT(a) FROM ArrangeSeat a WHERE a.subject = :subject")
    Long countStudentsBySubject(@Param("subject") String subject);

    
}
