package com.znsd.sportsvideo.service;

import com.znsd.sportsbean.util.PageRequest;
import com.znsd.sportsbean.util.PageResult;
import com.znsd.sportsbean.video.VideoCommentDomain;

public interface CommonService {
    /**
     * 获取该用户所有视频的评论数
     *
     * @param userId
     * @return
     */
    public Integer getCommonNumber(String userId);

    /**
     * 获取该集合视频的所有评论
     *
     * @param collId 视频集合collId
     * @return
     */
    public PageResult getAloneConllectCommon(PageRequest pageRequest, String collId);

    /**
     * 添加一条评论
     *
     * @param videoCommentDomain
     */
    public VideoCommentDomain insertComment(VideoCommentDomain videoCommentDomain);
}
