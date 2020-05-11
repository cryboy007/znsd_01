package com.znsd.sportsrootweb.controller;

import com.github.pagehelper.PageInfo;
import com.znsd.sportsbean.user.UserDomain;
import com.znsd.sportsbean.util.Base64Utils;
import org.apache.catalina.User;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/server/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.server}")
    private String userPath;

    @Value("${image.server}")
    private String imagePath;

    @GetMapping("/list")
    public PageInfo<UserDomain> getList(Integer page, Integer limit) throws JSONException {
        System.out.println(123123);
        System.out.println(page + "/" + limit);
        PageInfo<UserDomain> list = restTemplate.getForObject(userPath + "fy?page=" + page + "&limit=" + limit, PageInfo.class);
        System.out.println(list.getList());
        return list;
    }

    @PostMapping("/add")
    public boolean add(MultipartFile file, String name, String username, String password, String gender, String email, String birthday, String typeid, Integer status) throws ParseException, IOException {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        MultiValueMap<String, Object> map2 = new LinkedMultiValueMap<>();
        String base64 = Base64Utils.getBase64FromInputStream(file.getInputStream());
        int i = file.getOriginalFilename().lastIndexOf(".");
        String uuid = UUID.randomUUID().toString();
        String fileName = uuid + file.getOriginalFilename().substring(i, file.getOriginalFilename().length());
        map2.add("file", base64);// 添加文件到表单
        map2.add("fileName", fileName);
        map.add("password", password);
        map.add("name", name);
        map.add("username", username);
        map.add("gender", gender);
        map.add("email", email);
        map.add("typeid", typeid);
        map.add("status", status);
        map.add("birth", birthday);
        map.add("image", fileName);
        map.add("id", uuid);
        restTemplate.postForObject(imagePath + "uploadImage", map2, boolean.class);
        return restTemplate.postForObject(userPath + "add", map, boolean.class);
    }

    @PostMapping("/update")
    public boolean update(String id, String name, String username, String password, String gender, String email, String birthday, String typeid, Integer status) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        Date date = simpleDateFormat.parse(birthday);
        UserDomain userDomain = new UserDomain();
        userDomain.setId(id);
        userDomain.setName(name);
        userDomain.setUsername(username);
        userDomain.setPassword(password);
        userDomain.setGender(gender);
        userDomain.setEmail(email);
        userDomain.setBirthday(date);
        userDomain.setTypeid(typeid);
        userDomain.setStatus(status);
        System.out.println(userDomain);
        restTemplate.postForObject(userPath + "update", userDomain, boolean.class);
        return true;
    }

    @PostMapping("/delete")
    public boolean update(String id) throws ParseException {
        System.out.println("id=" + id);
        return restTemplate.postForObject(userPath + "delete", id, boolean.class);
    }


    @PostMapping("/login")
    public UserDomain login(String username, String password) {
        System.out.println(username + "//" + password);
        try {
            MultiValueMap map = new LinkedMultiValueMap();
            map.add("password", password);
            map.add("username", username);
            return restTemplate.postForObject(userPath + "sigIn", map, UserDomain.class);
        } catch (Exception e) {
            System.out.println("登陆失败");
            return null;
        }
    }
}
