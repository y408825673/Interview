package com.system;
import com.service.ItvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends ItvService {
//    @Autowired
//    private UserRepository userRepository;
    public  boolean  checkAccount(String userID,String password){
        //User user=userRepository.findByUserIDAndPassword(userID,password);
        return  true;
//        if (user!=null){
//            return true;
//        }else {
//            return false;
//        }

    }
//    public User  getUserByUserID(String userID){
//        return userRepository.findByUserID(userID);
//    }

}
