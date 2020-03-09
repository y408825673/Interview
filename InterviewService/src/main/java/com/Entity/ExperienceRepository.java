package com.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience,Long> {
    Experience findByExperienceID(long experienceID);
    @Query("select e from Experience e  where e.interviewer.interviewerID = ?1")
    List<Experience> findAllByInterviewer(long interviewerID );
}
