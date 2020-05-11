package com.znsd.sportscommodity.login.service;

import com.znsd.sportsbean.user.UserDomain;
import com.znsd.sportslog.annotation.OperationType;
import com.znsd.sportslog.annotation.SystemControllerLog;

public interface LoginService {

    public UserDomain queryLogin(String userName, String password);
}
