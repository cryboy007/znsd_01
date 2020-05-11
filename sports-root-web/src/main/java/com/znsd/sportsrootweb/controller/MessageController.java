package com.znsd.sportsrootweb.controller;

import com.github.pagehelper.PageInfo;
import com.znsd.sportsbean.http.MessageDomain;
import com.znsd.sportsbean.view.MessageAndUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/server/message")
public class MessageController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/send")
    public boolean send(MessageDomain messageDomain) {
        return restTemplate.postForObject("http://192.168.1.10:8010/send", messageDomain, boolean.class);
    }

    @GetMapping("/list")
    public PageInfo<MessageAndUser> getList(Integer page, Integer limit) {
        return restTemplate.getForObject("http://192.168.1.10:8010/getList2?page=" + page + "&limit=" + limit, PageInfo.class);
    }

    @PostMapping("/delete")
    public boolean delete(MessageAndUser messageAndUser) {
        System.out.println(messageAndUser);
        return restTemplate.postForObject("http://192.168.1.10:8010/delete", messageAndUser, boolean.class);
    }
}
