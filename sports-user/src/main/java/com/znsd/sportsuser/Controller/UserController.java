package com.znsd.sportsuser.Controller;

import com.github.pagehelper.PageInfo;
import com.znsd.sportsbean.user.UserDomain;
import com.znsd.sportslog.annotation.OperationType;
import com.znsd.sportslog.annotation.SystemControllerLog;
import com.znsd.sportsuser.Service.IMailService;
import com.znsd.sportsuser.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @SystemControllerLog(operationType = OperationType.SELECT, description = "根据id查询用户")
    @GetMapping("/query")
    public UserDomain queryUser(String id) {

        UserDomain userDomain = userService.queryUser(id);

        return userDomain;
    }

    @GetMapping("/all")
    @SystemControllerLog(operationType = OperationType.SELECT, description = "查询全部用户")
    public List<UserDomain> queryAll() {

        List<UserDomain> userDomains = userService.queryAll();
        for (UserDomain userDomain : userDomains) {
            System.out.println(userDomain);
        }

        return userDomains;
    }

    @GetMapping("/fy")
    @SystemControllerLog(operationType = OperationType.SELECT, description = "分页查询用户")
    public PageInfo<UserDomain> fenYe(int page, int limit) {
        System.out.println(page + "------" + limit);
        return userService.fenYe(page, limit);
    }

    // 根据用户名、姓名模糊查询
    @GetMapping("/fuzzy")
    @SystemControllerLog(operationType = OperationType.SELECT, description = "分页模糊用户")
    public PageInfo<UserDomain> fuzzyQuery(String value, int page, int limit) {

        return userService.fuzzyQuery(value, page, limit);
    }

    @CrossOrigin
    @PostMapping("/add")
    @SystemControllerLog(operationType = OperationType.INSERT, description = "用户添加")
    public boolean addUser(@RequestBody UserDomain userDomain, String birth) throws ParseException {

        System.out.println("Add------------" + userDomain);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        Date date = simpleDateFormat.parse(birth);

        UserDomain domain = userService.queryName(userDomain.getUsername());
        if (domain != null) {

            return false;
        } else {
            userDomain.setBirthday(date);
            boolean flag1 = userService.addUser(userDomain);
            return flag1;
        }
    }

    @PostMapping("/update")
    @SystemControllerLog(operationType = OperationType.UPDATE, description = "根据id修改用户")
    public boolean updateUser(@RequestBody UserDomain userDomain) {

        boolean flag = userService.updateUser(userDomain);

        return flag;
    }


    @PostMapping("/delete")
    @SystemControllerLog(operationType = OperationType.DELETE, description = "根据id删除用户")
    public boolean deleteUser(@RequestBody String id) {

        boolean flag = userService.deleteUser(id);
        return flag;
    }

    @PostMapping("/updateMoney")
    @SystemControllerLog(operationType = OperationType.UPDATE, description = "根据id修改用户")
    public int updateMoney(String userId, double money) {

        return userService.updateMoney(userId, money);
    }


    @CrossOrigin
    @PostMapping("/sign")
    @SystemControllerLog(operationType = OperationType.SELECT, description = "用户登录")
    public UserDomain sigInUser(@RequestBody String username, @RequestBody String password) {

        System.out.println("  UserController-----" + username + "----" + password);

        UserDomain userDomain = userService.sigInUser(username, password);
        System.out.println(userDomain + "---------------");
        if (userDomain != null) {
            System.out.println("===============" + userDomain);
        }
        return userDomain;
    }

    @CrossOrigin
    @PostMapping("/sigIn")
    @SystemControllerLog(operationType = OperationType.SELECT, description = "用户登录")
    public UserDomain sigInUser2(String username, String password) {

        System.out.println("  UserController-----" + username + "----" + password);

        UserDomain userDomain = userService.sigInUser(username, password);
        System.out.println(userDomain + "---------------");
        if (userDomain != null) {
            System.out.println("===============" + userDomain);
        }
        return userDomain;
    }


    // 调用邮箱
    @Autowired
    private IMailService iMailService;

    public void senMail(String to, String subject, String content) {

        /*String id = GenerateId.getId();
        iMailService.sendSimpleMail("1486617253@qq.com","这是测试",id);*/

        iMailService.sendSimpleMail(to, subject, content);
    }


}
