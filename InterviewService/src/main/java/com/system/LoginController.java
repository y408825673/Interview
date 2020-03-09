package com.system;



//import com.entity.*;
//import com.system.Util.JwtUtil;
import com.Entity.Interviewer;
import com.common.StringUtil;
import com.common.Util;
import com.system.entity.Result;
import com.system.entity.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;
@RestController
public class LoginController {
    @Autowired
    private  LoginService loginService;

//    @Autowired
//    private PeriodRepository periodRepository;
//    @Autowired
//    private GroupAuthRepository groupAuthRepository;
//    @Autowired
//    private ManagerRoleRepository managerRoleRepository;
//    @Autowired
//    private EmployeeRepository employeeRepository;


    /**
     * @description 登陆接口
     * @return token
     */
    @CrossOrigin
    @RequestMapping(value = "/itvLogin",method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody Map<String,String> map){

        String idNumber= Util.getNotNullString(map.get("idNumber").trim());
        Interviewer itv=loginService.getInterviewerByIdNumber(idNumber);
        return ResultFactory.buildSuccessResult(itv);
    }
}