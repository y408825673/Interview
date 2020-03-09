package com.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewerRepository extends JpaRepository<Interviewer,Long> {
    Interviewer findByInterviewerIDAndValidflag(long interviewerID,Integer validFlag);
    Interviewer findByIdNumberAndValidflag(String idNumber,Integer validFlag);

}
