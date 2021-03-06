package com.znsd.sportsrootweb.controller;

import com.znsd.sportsbean.video.VideoTypeDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/server/videoType")
public class VideoTypeController {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/list")
    public List<VideoTypeDomain> getList() {
        List<VideoTypeDomain> list = restTemplate.getForObject("http://192.168.1.10:8001/findType", List.class);
        return list;
    }


}
