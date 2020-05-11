package com.znsd.sportsvideo.controller;

import com.znsd.sportsbean.util.PageRequest;
import com.znsd.sportsbean.util.PageResult;
import com.znsd.sportsbean.video.VideoCommentDomain;
import com.znsd.sportsvideo.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 评论
 */
@RestController
public class CommonController {

    @Autowired
    private CommonService commonService;

    /**
     * 获取该用户所有视频的评论数
     *
     * @param userId
     * @return
     */
    @GetMapping("/getCommonNumber")
    public Integer getCommonNumber(String userId) {
        Integer commonNumber = commonService.getCommonNumber(userId);
        if (commonNumber == null) {
            return 0;
        }
        return commonNumber;
    }

    /**
     * 获取该视频的评论(分页)
     */
    @GetMapping("/getAloneConllectCommon")
    public PageResult getAloneConllectCommon(PageRequest pageRequest, String videoId) {
        PageResult aloneConllectCommon = commonService.getAloneConllectCommon(pageRequest, videoId);
        return aloneConllectCommon;
    }

    /**
     * 添加一条评论
     *
     * @param videoCommentDomain
     */
    @GetMapping("/insertComment")
    @ResponseBody
    public VideoCommentDomain insertComment(VideoCommentDomain videoCommentDomain) {
        System.out.println(videoCommentDomain + "&***********");
        return commonService.insertComment(videoCommentDomain);
    }

}
