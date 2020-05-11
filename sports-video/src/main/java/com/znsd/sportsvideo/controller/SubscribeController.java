package com.znsd.sportsvideo.controller;

import com.znsd.sportsbean.video.SubscribeDomain;
import com.znsd.sportsvideo.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SubscribeController {

    @Autowired
    private SubscribeService subscribeService;

    /**
     * 添加一条订阅
     *
     * @param subscribeDomain
     */
    @GetMapping("/insertSubscribe")
    @ResponseBody
    public SubscribeDomain insertSubscribe(SubscribeDomain subscribeDomain) {
        subscribeService.insertSubscribe(subscribeDomain);
        return subscribeDomain;
    }


    /**
     * 判断并得到这个视频是否已订阅 , videoId,userId
     *
     * @param subscribeDomain
     */
    @GetMapping("/getSubscribe")
    @ResponseBody
    public Integer getSubscribe(SubscribeDomain subscribeDomain) {
        Integer subscribe = subscribeService.getSubscribe(subscribeDomain);
        return subscribe;
    }


}
