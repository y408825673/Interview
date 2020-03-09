package com.Entity;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "ITV_M_Interviewer")
public class Interviewer extends Model {
    @Id
    @Column(name = "Interviewer_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long interviewerID;
    //基础信息
    @Column(name = "InterviewerName")
    private String interviewerName;
    @Column(name = "IdNumber")
    private String idNumber;
    @Column(name = "BirthDate")
    private Date birthDate;
    @Column(name = "NativePlace")
    private String nativePlace;
    @Column(name = "Gender")
    private String gender;
    @Column(name = "Ethnic")
    private String ethnic;
    @Column(name = "PoliticalStatus")
    private String politicalStatus;
    @Column(name = "MarriageStatus")
    private String marriageStatus;
    @Column(name = "SpouseName")
    private String spouseName;
    @Column(name = "SpouseIdNumber")
    private String spouseIdNumber;
    @Column(name = "NativeAddress")
    private String nativeAddress;
    @Column(name = "FamilyAddress")
    private String familyAddress;
    @Column(name = "NowAddress")
    private String nowAddress;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Email")
    private String email;
    @Column(name = "Source")
    private String source;
    @Column(name = "AdditionInternet")
    private String additionInternet;
    @Column(name = "AdditionEmp")
    private String additionEmp;
    @Column(name = "AdditionOther")
    private String additionOther;
    //健康声明
    @Column(name = "Hospitalized")
    private String hospitalized;
    @Column(name = "respiratory")
    private String respiratory;
    @Column(name = "Asthma")
    private String asthma;
    @Column(name = "Heart")
    private String heart;
    @Column(name = "Skin")
    private String skin;
    @Column(name = "Excited")
    private String excited;
    @Column(name = "Drunk")
    private String drunk;
    @Column(name = "Genetic")
    private String genetic;
    @Column(name = "Epilepsy")
    private String epilepsy;
    @Column(name = "Hear")
    private String hear;
    @Column(name = "Other")
    private String other;

    //在职亲属信息
    @Column(name = "relatedFlag")
    private String relatedFlag;
    @Column(name = "RelatedName")
    private String relatedName;
    @Column(name = "RelatedEmployee_ID")
    private String relatedEmployee_ID;
    @Column(name = "RelatedRelationship")
    private String relatedRelationship;

    //信息确认
    @Column(name = "Unlawful")
    private String unlawful;
    @Column(name = "ExpectedSalary")
    private String expectedSalary;
    @Column(name = "RegDate")
    private Date regDate;
    @Column(name = "DormFlag")
    private String dormFlag;
    //工作经历
    @Column(name = "ExperienceFlag")
    private String experienceFlag;
    @OneToMany(targetEntity=Experience.class,mappedBy="interviewer",fetch = FetchType.LAZY )
    private List<Experience> experienceList=new ArrayList<Experience>();
    //教育背景
    @OneToMany(targetEntity=Education.class,mappedBy="interviewer",fetch = FetchType.LAZY )
    private List<Education> educationList=new ArrayList<Education>();
    //亲属信息
    @OneToMany(targetEntity=Relative.class,mappedBy="interviewer",fetch = FetchType.LAZY )
    private List<Relative> relativeList=new ArrayList<Relative>();


    public Interviewer() {
    }

}
