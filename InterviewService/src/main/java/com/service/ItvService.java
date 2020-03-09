package com.service;

import com.Entity.*;
import javassist.expr.Expr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItvService {
    @Autowired private InterviewerRepository interviewerRepository;
    @Autowired private ExperienceRepository experienceRepository;
    @Autowired private EducationRepository educationRepository;
    @Autowired private RelativeRepository relativeRepository;

    //根据ID获取Interviewer
    public Interviewer getInterviewerByID(long interviewerID){
        return  interviewerRepository.findByInterviewerIDAndValidflag(interviewerID, 1);
    }
    //根据IdNumber获取Interviewe/查询是否存在Interviewer，不存在则创建
    public Interviewer getInterviewerByIdNumber(String idNumber){
        Interviewer itv=interviewerRepository.findByIdNumberAndValidflag(idNumber, 1);
        if (itv==null){
            itv=new Interviewer();
            itv.setIdNumber(idNumber);
            interviewerRepository.save(itv);
        }
        return  itv;
    }
    //保存面试者信息
    public void saveInterviewer(Interviewer itv){
        //保存工作经历
        //整存整删，这样可以简单的达到页面上有啥就存啥，在页面上删除时不需要处理后台
        //删除表里已经存在的数据
        List<Experience> exprExistList = experienceRepository.findAllByInterviewer(itv.getInterviewerID());
        for (Experience exprExist:exprExistList) experienceRepository.delete(exprExist);
        //将页面传过的数据存入表中
        List<Experience> newExprList=new ArrayList<Experience>();
        for(int i=0;i<itv.getExperienceList().size();i++){
            Experience expr= itv.getExperienceList().get(i);
            Experience newExpr=new Experience(itv,expr.getCompany(),expr.getCity(),expr.getJobTitle(),expr.getSalary(),expr.getFromDate(),expr.getToDate(),expr.getSupervior(),expr.getTelephone(),expr.getResignReason());
            experienceRepository.save(newExpr);
            newExprList.add(newExpr);
        }
        itv.setExperienceList(newExprList);

        //保存教育背景
        List<Education> eduExistList = educationRepository.findAllByInterviewer(itv.getInterviewerID());
        for (Education eduExist:eduExistList) educationRepository.delete(eduExist);
        List<Education> newEduList= new ArrayList<Education>();
        for (int i=0;i<itv.getEducationList().size();i++){
            Education edu=itv.getEducationList().get(i);
            Education newEdu=new Education(itv,edu.getSchool(),edu.getArea(),edu.getRegDate(),edu.getGraDate(),edu.getProfession(),edu.getDegree(),edu.getEduType(),edu.getEduSort());
            educationRepository.save(newEdu);
            newEduList.add(newEdu);
        }
        itv.setEducationList(newEduList);

        //保存亲属信息
        List<Relative> relativeList= relativeRepository.findAllByInterviewer(itv.getInterviewerID());
        for (Relative relative:relativeList) relativeRepository.delete(relative);
        List<Relative> newRlatList= new ArrayList<Relative>();
        for (int i=0;i<itv.getRelativeList().size();i++){
            Relative relative=itv.getRelativeList().get(i);
            Relative newRlat=new Relative(itv,relative.getRelationship(),relative.getName(),relative.getAge(),relative.getJob(),relative.getWorkplace(),relative.getHomeAddress(),relative.getTelephone(),relative.getEmergency());
            relativeRepository.save(newRlat);
            newRlatList.add(newRlat);
        }
        itv.setRelativeList(newRlatList);

        //保存所有基础信息
        interviewerRepository.save(itv);
    }
    /*删除工作经历*/
    public  void  cancelExpr(String exprienceID){
        Experience expr=experienceRepository.findByExperienceID(Long.parseLong(exprienceID));
        experienceRepository.delete(expr);
    }







}
