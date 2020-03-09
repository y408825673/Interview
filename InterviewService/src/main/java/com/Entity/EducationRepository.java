package com.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education,Long> {
    @Query("select e from Education e  where e.interviewer.interviewerID = ?1")
    List<Education> findAllByInterviewer(long interviewerID);

}
