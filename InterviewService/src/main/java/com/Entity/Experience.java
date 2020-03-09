package com.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "ITV_D_Experience")
public class Experience extends ModelAtom {
    @Id
    @Column(name = "Experience_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long experienceID;
    @ManyToOne(cascade = { CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "Interviewer_FK")
    @JsonIgnore
    private Interviewer interviewer;
    @Column(name = "Company")
    private String company;
    @Column(name = "City")
    private String city;
    @Column(name = "JobTitle")
    private String jobTitle;
    @Column(name = "Salary")
    private String salary;
    @Column(name = "FromDate")
    private Date fromDate;
    @Column(name = "ToDate")
    private Date toDate;
    @Column(name = "Supervior")
    private String supervior;
    @Column(name = "Telephone")
    private String telephone;
    @Column(name = "ResignReason")
    private String resignReason;

    public Experience() {
    }

    public Experience(Interviewer interviewer, String company, String city, String jobTitle, String salary, Date fromDate, Date toDate, String supervior, String telephone, String resignReason) {
        this.interviewer = interviewer;
        this.company = company;
        this.city = city;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.supervior = supervior;
        this.telephone = telephone;
        this.resignReason = resignReason;
    }
}
