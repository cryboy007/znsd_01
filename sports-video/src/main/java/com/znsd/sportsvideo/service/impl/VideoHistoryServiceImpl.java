package com.znsd.sportsvideo.service.impl;

import com.znsd.sportsbean.video.VideoHistoryDomain;
import com.znsd.sportsvideo.dao.VideoHistoryDao;
import com.znsd.sportsvideo.service.VideoHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoHistoryServiceImpl implements VideoHistoryService {
    @Autowired
    private VideoHistoryDao videoHistoryDao;

    @Override
    public VideoHistoryDomain insertHistory(VideoHistoryDomain videoHistoryDomain) {
        VideoHistoryDomain history = getHistory(videoHistoryDomain);
        if (history != null) {
            updateHistory(history.getId());
        } else {
            videoHistoryDao.insertHistory(videoHistoryDomain);
        }
        return videoHistoryDomain;
    }

    @Override
    public VideoHistoryDomain getHistory(VideoHistoryDomain videoHistoryDomain) {
        return videoHistoryDao.getHistory(videoHistoryDomain);
    }

    @Override
    public void updateHistory(String id) {
        videoHistoryDao.updateHistory(id);
    }
}
