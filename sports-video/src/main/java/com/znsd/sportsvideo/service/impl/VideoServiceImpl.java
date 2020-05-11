package com.znsd.sportsvideo.service.impl;

import com.znsd.sportsbean.video.VideoDomain;
import com.znsd.sportsvideo.dao.VideoDao;
import com.znsd.sportsvideo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;


    @Override
    public VideoDomain insertVideo(VideoDomain videoDomain) {
        videoDao.insertVideo(videoDomain);
        return videoDomain;

    }


    @Override
    public void updateVideo(VideoDomain videoDomain) {

        videoDao.updateVideo(videoDomain);
    }


    @Override
    public void deleteVideo(String id) {
        videoDao.deleteVideo(id);
    }


}
