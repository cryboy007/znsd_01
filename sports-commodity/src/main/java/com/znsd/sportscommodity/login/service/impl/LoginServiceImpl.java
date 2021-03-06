package com.znsd.sportscommodity.login.service.impl;

import com.znsd.sportsbean.user.UserDomain;
import com.znsd.sportscommodity.login.dao.LoginDao;
import com.znsd.sportscommodity.login.service.LoginService;
import com.znsd.sportslog.annotation.OperationType;
import com.znsd.sportslog.annotation.SystemControllerLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    LoginDao loginDao;

    @Override


    public UserDomain queryLogin(String userName, String password) {
        return this.loginDao.queryLogin(userName, password);
    }
}
