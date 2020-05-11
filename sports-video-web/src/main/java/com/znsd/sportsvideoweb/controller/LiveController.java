package com.znsd.sportsvideoweb.controller;

import com.github.pagehelper.PageInfo;
import com.znsd.sportsbean.live.LiveDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/live")
public class LiveController {
    @Autowired
    public RestTemplate restTemplate;

    @GetMapping("/get")
    public LiveDomain getLive(String id) {
        LiveDomain liveDomain = restTemplate.getForObject("http://192.168.1.10:8006/server/live/get?id=" + id, LiveDomain.class);
        return liveDomain;
    }

    @GetMapping("/list")
    public PageInfo getList(Integer page, Integer limit) {
        System.out.println(page + "/" + limit);
        PageInfo pageInfo = restTemplate.getForObject("http://192.168.1.10:8006/server/live/list?page=" + page + "&limit=" + limit, PageInfo.class);
        return pageInfo;
    }
}
