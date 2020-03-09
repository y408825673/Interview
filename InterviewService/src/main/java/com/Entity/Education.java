package com.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "ITV_D_Education")
public class Education {
    @Id
    @Column(name = "Education_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long educationID;
    @ManyToOne(cascade = { CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "Interviewer_FK")
    @JsonIgnore
    private Interviewer interviewer;
    @Column(name = "School")
    private String school;
    @Column(name = "Area")
    private String area;
    @Column(name = "RegDate")
    private Date regDate;
    @Column(name = "GraDate")
    private Date graDate;
    @Column(name = "Profession")
    private String profession;
    @Column(name = "Degree")
    private String degree;
    @Column(name = "EduType")
    private String eduType;
    @Column(name = "EduSort")
    private String eduSort;

    public Education() {
    }
    public Education(Interviewer interviewer, String school, String area, Date regDate, Date graDate, String profession, String degree, String eduType, String eduSort) {
        this.interviewer = interviewer;
        this.school = school;
        this.area = area;
        this.regDate = regDate;
        this.graDate = graDate;
        this.profession = profession;
        this.degree = degree;
        this.eduType = eduType;
        this.eduSort = eduSort;
    }
}
