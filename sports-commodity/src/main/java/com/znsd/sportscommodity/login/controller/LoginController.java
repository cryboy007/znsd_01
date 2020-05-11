package com.znsd.sportscommodity.login.controller;

import com.znsd.sportsbean.user.UserDomain;
import com.znsd.sportscommodity.login.service.LoginService;
import com.znsd.sportslog.annotation.OperationType;
import com.znsd.sportslog.annotation.SystemControllerLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("login")
public class LoginController {
    @Resource
    LoginService loginService;

    @RequestMapping("yz")
    @SystemControllerLog(description = "用户登录", operationType = OperationType.SELECT)
    public UserDomain login(String userName, String password) {
        return this.loginService.queryLogin(userName, password);
    }

}
