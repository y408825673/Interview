package com.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "ITV_D_Relative")
public class Relative extends ModelAtom {
    @Id
    @Column(name = "Relative_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long relativeID;
    @ManyToOne(cascade = { CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "Interviewer_FK")
    @JsonIgnore
    private Interviewer interviewer;
    @Column(name = "Relationship")
    private String relationship;
    @Column(name = "name")
    private String name;
    @Column(name = "Age")
    private String age;
    @Column(name = "Job")
    private String job;
    @Column(name = "Workplace")
    private String workplace;
    @Column(name = "HomeAddress")
    private String homeAddress;
    @Column(name = "Telephone")
    private String telephone;
    @Column(name = "Emergency")
    private String emergency;

    public Relative() {
    }
    public Relative(Interviewer interviewer, String relationship, String name, String age, String job, String workplace, String homeAddress, String telephone, String emergency) {
        this.interviewer = interviewer;
        this.relationship = relationship;
        this.name = name;
        this.age = age;
        this.job = job;
        this.workplace = workplace;
        this.homeAddress = homeAddress;
        this.telephone = telephone;
        this.emergency = emergency;
    }
}
