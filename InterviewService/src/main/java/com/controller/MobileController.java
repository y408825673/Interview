package com.controller;

import com.Entity.Interviewer;
import com.Entity.InterviewerRepository;
import com.common.Util;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.MobileService;
import com.system.entity.Result;
import com.system.entity.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class MobileController {
    @Autowired private MobileService mobileService;

    @RequestMapping(value = "/getInterviewer", method = RequestMethod.POST)
    public Result getInterviewer(@RequestBody Map<String, String> map) {
        String interviewerID = Util.getNotNullString(map.get("interviewerID").trim());
        Interviewer itv = mobileService.getInterviewerByID(Long.parseLong(interviewerID));
        if (itv != null) {
            return ResultFactory.buildSuccessResult(itv);
        } else {
            return ResultFactory.buildFailResult("未找到该人员的信息");
        }
    }


    @RequestMapping(value = "/saveInterviewer", method = RequestMethod.POST)
    public Result  saveInterviewer (@RequestBody Map<String, Object> map,ObjectMapper objectMapper) {
        try{
            Object obj=map.get("interviewer");
            Interviewer itv = objectMapper.convertValue(obj, new TypeReference<Interviewer>() {});
            if (itv==null ||itv.getInterviewerID() == 0){
                return ResultFactory.buidResult(401,"登陆信息失效",null);
            }else{
                mobileService.saveInterviewer(itv);
                return ResultFactory.buildSuccessMessage("保存成功");
            }

        }catch (Exception e){
            e.printStackTrace();
            return ResultFactory.buildFailResult("保存出现异常");
        }
    }
    @RequestMapping(value = "/cancelExpr", method = RequestMethod.POST)
    public Result cancelExpr(@RequestBody Map<String, String> map){
        String exprienceID=Util.getNotNullString(map.get("experienceID"));
        try {
        if (exprienceID==null||exprienceID.equals("")||exprienceID.equals("0")){
            return ResultFactory.buildSuccessMessage("删除成功");
        }else{
                mobileService.cancelExpr(exprienceID);
                return ResultFactory.buildSuccessMessage("删除成功");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return ResultFactory.buildFailResult("保存出现异常:"+e.toString());
        }
    }
}