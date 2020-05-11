package com.znsd.sportsvideo.dao;

import com.znsd.sportsbean.video.VideoHistoryDomain;

public interface VideoHistoryDao {
    /**
     * 添加历史记录
     *
     * @param videoHistoryDomain
     */
    public void insertHistory(VideoHistoryDomain videoHistoryDomain);

    /**
     * 判断该历史记录存不存在
     *
     * @param videoHistoryDomain
     */
    public VideoHistoryDomain getHistory(VideoHistoryDomain videoHistoryDomain);

    /**
     * 修改当前浏览时间
     *
     * @param id
     */
    public void updateHistory(String id);
}
