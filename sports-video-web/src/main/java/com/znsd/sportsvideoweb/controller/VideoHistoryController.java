package com.znsd.sportsvideoweb.controller;

import com.znsd.sportsbean.video.VideoHistoryDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class VideoHistoryController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 添加历史记录
     *
     * @param videoHistoryDomain
     */
    @PostMapping("/insertHistory")
    @ResponseBody
    public VideoHistoryDomain insertHistory(VideoHistoryDomain videoHistoryDomain) {
        System.out.println("cccccccccccccccc" + videoHistoryDomain.getVideoId());
        videoHistoryDomain.setUserId("6eeef258-91ae-4ee1-a941-b21da33378c9");
        String s = "http://localhost:8001/insertHistory?videoId=" + videoHistoryDomain.getVideoId() + "&userId=" + videoHistoryDomain.getUserId();
        return restTemplate.getForObject(s, VideoHistoryDomain.class);
    }
}
