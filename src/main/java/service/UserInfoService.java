package service;

import model.UserInfo;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    private SessionFactory sessionFactory;

    // Create
    @Transactional
    public void saveUserInfo(UserInfo userInfo){
        sessionFactory.getCurrentSession().save(userInfo);
    }

    // Read
    @Transactional
    public List<UserInfo> getAllUserInfoss() {
        Query query = sessionFactory.getCurrentSession().createQuery("from UserInfo");
        return query.list();
    }

    @Transactional
    public UserInfo getUserInfoByuid(int uid){
        return (UserInfo) sessionFactory.getCurrentSession().get(UserInfo.class, uid);
    }

//    @Transactional
//    public UserInfo getUserInfoByuid(int uid){
//        List<UserInfo> userInfoss = getAllUserInfoss();
//        UserInfo userInfoResult = new UserInfo();
//        for (UserInfo userInfo:userInfoss) {
//            if (userInfo.getUid() == uid) {
//                userInfoResult = userInfo;
//            }
//        }
//        return userInfoResult;
//    }

    @Transactional
    public UserInfo getUserInfoByUsername(String username){
        List<UserInfo> userInfoss = getAllUserInfoss();
        UserInfo userInfoResult = new UserInfo();
        for (UserInfo userInfo:userInfoss) {
            if (userInfo.getUsername().equals(username)) {
                userInfoResult = userInfo;
            }
        }
        return userInfoResult;
    }

//    @Transactional
//    public UserInfo getUserInfoByUsername(String username){
//        return (UserInfo) sessionFactory.getCurrentSession().get(UserInfo.class, username);
//    }

    @Transactional
    public UserInfo getUserInfoByEmail(String email){
        List<UserInfo> userInfoss = getAllUserInfoss();
        UserInfo userInfoResult = new UserInfo();
        for (UserInfo userInfo:userInfoss) {
            if (userInfo.getEmail().equals(email)) {
                userInfoResult = userInfo;
            }
        }
        return userInfoResult;
    }

//    @Transactional
//    public UserInfo getUserInfoByEmail(String email){
//        return (UserInfo) sessionFactory.getCurrentSession().get(UserInfo.class, email);
//    }

    @Transactional
    public UserInfo getUserInfoPhoneNumber(String phonenumber){
        List<UserInfo> userInfoss = getAllUserInfoss();
        UserInfo userInfoResult = new UserInfo();
        for (UserInfo userInfo:userInfoss) {
            if (userInfo.getPhonenumber().equals(phonenumber)) {
                userInfoResult = userInfo;
            }
        }
        return userInfoResult;
    }

//    @Transactional
//    public UserInfo getUserInfoPhoneNumber(String phonenumber){
//        return (UserInfo) sessionFactory.getCurrentSession().get(UserInfo.class, phonenumber);
//    }

    @Transactional
    public List<UserInfo> getUserInfoByName(String name){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserInfo.class);
        criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
        return criteria.list();
    }

    // If True == admin
    // If False == normal user
    @Transactional
    public List<UserInfo> getUserInfoByRole(Boolean role){
        List<UserInfo> userInfoss = getAllUserInfoss();
        List<UserInfo> userInfossResult = new ArrayList<UserInfo>();
        for (UserInfo userInfo:userInfoss) {
            if (userInfo.getRole() == role) {
                userInfossResult.add(userInfo);
            }
        }
        return userInfossResult;
    }

    // Update

    // Change username
    @Transactional
    public void updateUsernameOfUserInfo(UserInfo userInfoWithNewUsername){
        UserInfo userInfo = getUserInfoByuid(userInfoWithNewUsername.getUid());
        if (userInfo.getPassword().equals(userInfoWithNewUsername.getPassword())) {
            userInfo.setUsername(userInfoWithNewUsername.getUsername());
            sessionFactory.getCurrentSession().update(userInfo);
        }
    }

    // Change password
    @Transactional
    public void updatePasswordOfUserInfo(UserInfo userInfoWithNewPassword, String oldpassword) {
        UserInfo userInfo = getUserInfoByuid(userInfoWithNewPassword.getUid());
        if (userInfo.getPassword().equals(oldpassword)) {
            userInfo.setPassword(userInfoWithNewPassword.getPassword());
            sessionFactory.getCurrentSession().update(userInfo);
        }
    }

    // Change email
    @Transactional
    public void updateEmailOfUserInfo(UserInfo userInfoWithNewEmail){
        UserInfo userInfo = getUserInfoByuid(userInfoWithNewEmail.getUid());
        if (userInfo.getPassword().equals(userInfoWithNewEmail.getPassword())) {
            userInfo.setEmail(userInfoWithNewEmail.getEmail());
            sessionFactory.getCurrentSession().update(userInfo);
        }
    }

    // Change phone number
    @Transactional
    public void updatePhoneNumberOfUserInfo(UserInfo userInfoWithNewPhoneNumber){
        UserInfo userInfo = getUserInfoByuid(userInfoWithNewPhoneNumber.getUid());
        if (userInfo.getPassword().equals(userInfoWithNewPhoneNumber.getPassword())) {
            userInfo.setPhonenumber(userInfoWithNewPhoneNumber.getPhonenumber());
            sessionFactory.getCurrentSession().update(userInfo);
        }
    }

    // Change name
    @Transactional
    public void updateNameOfUserInfo(UserInfo userInfoWithNewName){
        UserInfo userInfo = getUserInfoByuid(userInfoWithNewName.getUid());
        if (userInfo.getPassword().equals(userInfoWithNewName.getPassword())) {
            userInfo.setName(userInfoWithNewName.getName());
            sessionFactory.getCurrentSession().update(userInfo);
        }
    }

    // Change role
    @Transactional
    public void updateRoleOfUserInfo(UserInfo userInfoWithNewRole){
        UserInfo userInfo = getUserInfoByuid(userInfoWithNewRole.getUid());
        if (userInfo.getPassword().equals(userInfoWithNewRole.getPassword())) {
            userInfo.setRole(userInfoWithNewRole.getRole());
            sessionFactory.getCurrentSession().update(userInfo);
        }
    }

    // Delete
    @Transactional
    public void deleteUserInfo(UserInfo userInfo){
        sessionFactory.getCurrentSession().delete(userInfo);
    }
}
