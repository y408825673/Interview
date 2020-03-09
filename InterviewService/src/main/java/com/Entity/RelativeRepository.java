package com.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RelativeRepository extends JpaRepository<Relative,Long> {
    @Query("select r from Relative r  where r.interviewer.interviewerID = ?1")
    List<Relative> findAllByInterviewer(long interviewerID);
}