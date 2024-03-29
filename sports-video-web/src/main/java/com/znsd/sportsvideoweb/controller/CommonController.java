package com.znsd.sportsvideoweb.controller;

import com.znsd.sportsbean.video.VideoCommentDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CommonController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 获取该用户所有视频的评论数
     *
     * @param
     * @return
     */
    @GetMapping("/getCommonNumber")
    @ResponseBody
    public Integer getCommonNumber() {
        return restTemplate.getForObject("http://localhost:8001/getCommonNumber?userId=6b94707d7eef40d7b74f204bbaeca29f", Integer.class);
    }

    @PostMapping("/insertComment")
    public ModelAndView insertComment(VideoCommentDomain videoCommentDomain, HttpServletRequest request) {

        ModelAndView mv = new ModelAndView();
        videoCommentDomain.setUserId("cfcf6830-bb7a-4e88-b1d8-97ef2dbac011");
        String s = "http://localhost:8001/insertComment?videoId=" + videoCommentDomain.getVideoId() + "&userId=" + videoCommentDomain.getUserId() + "&comment=" + videoCommentDomain.getComment();
        VideoCommentDomain videoCommentDomain1 = restTemplate.getForObject(s, VideoCommentDomain.class);
        mv.setViewName("redirect:findVideoById/" + videoCommentDomain1.getVideoId());
        return mv;
    }

}
