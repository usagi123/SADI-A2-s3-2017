package controller;

import model.UserInfoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.UserInfoResultService;

import java.util.List;

@RestController
public class UserInfoResultController {
    @Autowired
    private UserInfoResultService userInfoResultService;

    // Create
    @RequestMapping(path = "/userInfoResultServices/create", method = RequestMethod.POST)
    public void saveUserInfoResult(@RequestBody UserInfoResult userInfoResult){
        userInfoResultService.saveUserInfoResult(userInfoResult);
    }

    // Read
    @RequestMapping(path = "/userInfoResultServices/getAll", method = RequestMethod.GET)
    public List<UserInfoResult> getAllUserInfoResults(){
        return userInfoResultService.getAllUserInfoResults();
    }

    @RequestMapping(path="/userInfoResultServices/readByuid/{uid}", method = RequestMethod.GET)
    public List<UserInfoResult> getUserInfoResultsByuid(@PathVariable int uid){
        return userInfoResultService.getUserInfoResultsByuid(uid);
    }

    @RequestMapping(path="/userInfoResultServices/readByaid/{rid}", method = RequestMethod.GET)
    public UserInfoResult getUserInfoResultByrid(@PathVariable int rid){
        return userInfoResultService.getUserInfoResultByrid(rid);
    }

    // Update & Delete
    // Update and Delete result is logically not allowed
}
