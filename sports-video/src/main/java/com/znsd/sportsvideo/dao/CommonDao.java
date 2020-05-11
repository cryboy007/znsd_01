package com.znsd.sportsvideo.dao;

import com.znsd.sportsbean.video.VideoCommentDomain;

import java.util.List;

public interface CommonDao {

    /**
     * 获取该用户所有视频的评论数
     *
     * @param userId
     * @return
     */
    public Integer getCommonNumber(String userId);

    /**
     * 获取该视频集合的所有评论
     */
    public List<VideoCommentDomain> getAloneConllectCommon(String collId);

    /**
     * 添加一条评论
     *
     * @param videoCommentDomain
     */
    public void insertComment(VideoCommentDomain videoCommentDomain);
}
