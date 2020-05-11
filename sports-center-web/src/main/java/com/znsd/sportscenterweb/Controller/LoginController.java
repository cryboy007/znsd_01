package com.znsd.sportscenterweb.Controller;


import com.znsd.sportsbean.user.UserDomain;
import com.znsd.sportscenterweb.Utils.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class LoginController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("login")
    public String login() {
        return "denglu.html";
    }

    @RequestMapping("login2")
    public String login2() {
        return "zhuce.html";
    }

    @RequestMapping("index")
    public String index() {
        return "index.html";
    }

    @RequestMapping("login4")
    public String login4() {
        return "index.html";
    }

    @RequestMapping("login5")
    public String login5() {
        return "index.html";
    }

    @RequestMapping("login6")
    public String login6() {
        return "index.html";
    }

    @RequestMapping("login7")
    public String login7() {
        return "index.html";
    }

    @RequestMapping("login8")
    public String login8() {
        return "index.html";
    }

    @RequestMapping("login9")
    public String login9() {
        return "index.html";
    }


    @RequestMapping("/dengLu")
    public String dengLu(String userName, String password, Model model) {

        System.out.println(userName + "-------" + password);
        UserDomain user = restTemplate.getForObject("http://localhost:8008/login/yz?userName=" + userName + "&password=" + password, UserDomain.class);
        System.out.println(user);

        if (user != null) {
            return "index.html";
        } else {
            model.addAttribute("msg", "您的用户名或密码输入有误！");
            return "denglu.html";
        }
    }

    @RequestMapping("/zhuCe")
    public String zhuCe(String username, String password, String email, String name, String gender, String birth, Model model) throws ParseException {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        Date date = simpleDateFormat.parse(birth);

        System.out.println(username);
        System.out.println(password);
        System.out.println(email);
        System.out.println(name);
        System.out.println(gender);
        System.out.println(date);
        System.out.println(Uuid.getId());

        UserDomain userDomain = new UserDomain();
        userDomain.setId(Uuid.getId());
        userDomain.setUsername(username);
        userDomain.setPassword(password);
        userDomain.setEmail(email);
        userDomain.setName(name);
        userDomain.setGender(gender);
        userDomain.setBirthday(date);
        Boolean flag = restTemplate.postForObject("http://192.168.1.187:8002/add", userDomain, boolean.class);
        if (flag) {
            return "denglu.html";
        } else {
            model.addAttribute("msg", "用户名已存在");
            return "zhuce.html";
        }
    }


    @RequestMapping("/start")
    public String Personal() {
        return "Personal.html";
    }


}
