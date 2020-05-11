package com.znsd.sportsrootweb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.znsd.sportsbean.http.HttpResponse;
import com.znsd.sportsbean.http.HttpResponse2;
import com.znsd.sportsbean.live.LiveDomain;
import com.znsd.sportsbean.live.LiveDomainList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/server/live")
public class LiveController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${live.server}")
    private String livePath;

    @RequestMapping(value = "/list")
    public PageInfo getList(Integer page, Integer limit) {
        System.out.println(page + "/" + limit);
        page = page - 1;
        String temp = restTemplate.getForObject(livePath + "live/list?start=" + page + "&limit=" + limit, String.class);
        HttpResponse response = JSON.parseObject(temp, HttpResponse.class);
        LiveDomainList liveDomainList = response.getData();
        liveDomainList.getRows();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotal(liveDomainList.getTotal());
        pageInfo.setList(liveDomainList.getRows());
        pageInfo.setPageNum(page + 1);
        pageInfo.setSize(limit);
        return pageInfo;
    }

    @RequestMapping("/get")
    public LiveDomain getLive(String id) {
        String temp = restTemplate.getForObject(livePath + "live/get?id=" + id, String.class);
        System.out.println(temp);
        HttpResponse2 response = JSONObject.parseObject(temp, HttpResponse2.class);
        System.out.println(response);
        return response.getData().get(0);
    }

    ;
}
