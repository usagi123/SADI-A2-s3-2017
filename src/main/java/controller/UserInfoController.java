package controller;

import model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.UserInfoService;

import java.util.List;

@RestController
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    // Create
    @RequestMapping(path = "/userInfoss/create", method = RequestMethod.POST)
    public void saveUserInfo(@RequestBody UserInfo userInfo){
        userInfoService.saveUserInfo(userInfo);
    }

    // Read
    @RequestMapping(path = "/userInfoss/getAll", method = RequestMethod.GET)
    public List<UserInfo> getAllUserInfoss(){
        return userInfoService.getAllUserInfoss();
    }

    @RequestMapping(path="/userInfoss/readByuid/{uid}", method = RequestMethod.GET)
    public UserInfo getUserInfoByuid(@PathVariable int uid){
        return userInfoService.getUserInfoByuid(uid);
    }

    @RequestMapping(path="/userInfoss/readByUsername/{username}", method = RequestMethod.GET)
    public UserInfo getUserInfoByUsername(@PathVariable String username){
        return userInfoService.getUserInfoByUsername(username);
    }

    @RequestMapping(path="/userInfoss/readByEmail", method = RequestMethod.GET)
    public UserInfo getUserInfoByEmail(@RequestBody String email){
        return userInfoService.getUserInfoByUsername(email);
    }

    @RequestMapping(path="/userInfoss/readByPhoneNumber/{phonenumber}", method = RequestMethod.GET)
    public UserInfo getUserInfoPhoneNumber(@PathVariable String phonenumber){
        return userInfoService.getUserInfoPhoneNumber(phonenumber);
    }

    @RequestMapping(path="/userInfoss/readByName", method = RequestMethod.GET)
    public List<UserInfo> getUserInfoByName(@RequestBody String name){
        return userInfoService.getUserInfoByName(name);
    }

    @RequestMapping(path="/userInfoss/readByRole/{role}", method = RequestMethod.GET)
    public List<UserInfo> getUserInfoByRole(@PathVariable Boolean role){
        return userInfoService.getUserInfoByRole(role);
    }

    // Update
    @RequestMapping(path = "/userInfoss/updateUsername", method = RequestMethod.PATCH)
    public void updateUsernameOfUserInfo(@RequestBody UserInfo userInfoWithNewUsername){
        userInfoService.updateUsernameOfUserInfo(userInfoWithNewUsername);
    }

    @RequestMapping(path = "/userInfoss/updatePassword/{oldpassword}", method = RequestMethod.PATCH)
    public void updatePasswordOfUserInfo(@RequestBody UserInfo userInfoWithNewPassword, @PathVariable String oldpassword){
        userInfoService.updatePasswordOfUserInfo(userInfoWithNewPassword, oldpassword);
    }

    @RequestMapping(path = "/userInfoss/updateEmail", method = RequestMethod.PATCH)
    public void updateEmailOfUserInfo(@RequestBody UserInfo userInfoWithNewEmail){
        userInfoService.updateEmailOfUserInfo(userInfoWithNewEmail);
    }

    @RequestMapping(path = "/userInfoss/updatePhoneNumber", method = RequestMethod.PATCH)
    public void updatePhoneNumberOfUserInfo(@RequestBody UserInfo userInfoWithNewPhoneNumber){
        userInfoService.updatePhoneNumberOfUserInfo(userInfoWithNewPhoneNumber);
    }

    @RequestMapping(path = "/userInfoss/updateName", method = RequestMethod.PATCH)
    public void updateNameOfUserInfo(@RequestBody UserInfo userInfoWithNewName){
        userInfoService.updateNameOfUserInfo(userInfoWithNewName);
    }

    @RequestMapping(path = "/userInfoss/updateRole", method = RequestMethod.PATCH)
    public void updateRoleOfUserInfo(@RequestBody UserInfo userInfoWithNewRole){
        userInfoService.updateRoleOfUserInfo(userInfoWithNewRole);
    }

    // Delete
    @RequestMapping(path = "/userInfoss/deleteByuid/{uid}", method =RequestMethod.DELETE)
    public void deleteUserInfo(@PathVariable int uid){
        UserInfo userInfo = userInfoService.getUserInfoByuid(uid);
        userInfoService.deleteUserInfo(userInfo);
    }
}
