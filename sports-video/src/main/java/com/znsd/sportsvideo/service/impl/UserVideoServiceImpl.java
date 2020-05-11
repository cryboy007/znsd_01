package com.znsd.sportsvideo.service.impl;

import com.znsd.sportsbean.user.UserDomain;
import com.znsd.sportsbean.user.UserVideoDomain;
import com.znsd.sportsbean.video.VideoDomain;
import com.znsd.sportsvideo.dao.UserVideoDao;
import com.znsd.sportsvideo.service.UserVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserVideoServiceImpl implements UserVideoService {

    @Autowired
    private UserVideoDao userVideoDao;

    @Override
    public Integer getLikeNumber(String userId) {
        return userVideoDao.getLikeNumber(userId);
    }

    @Override
    public Integer getCollectNumber(String userId) {
        return userVideoDao.getCollectNumber(userId);
    }

    @Override
    public Integer getAloneField(UserVideoDomain videoDomain) {
        return userVideoDao.getAloneField(videoDomain);
    }

    @Override
    public Double getAloneVideoScore(String collId) {
        return userVideoDao.getAloneVideoScore(collId);
    }

    @Override
    public Integer getAloneVideoUserLook(String collId) {
        return userVideoDao.getAloneVideoUserLook(collId);
    }

    @Override
    public Integer getAloneVideoUserLookGroup(String collId) {
        return userVideoDao.getAloneVideoUserLookGroup(collId);
    }

    @Override
    public UserVideoDomain getUserAloneVideo(UserVideoDomain videoDomain) {
        return userVideoDao.getUserAloneVideo(videoDomain);
    }

    @Override
    public void addUserLikeAndCollectAndScore(UserVideoDomain videoDomain) {
        userVideoDao.addUserLikeAndCollectAndScore(videoDomain);
    }

    @Override
    public void updateUserLikeOrCollectOrScore(UserVideoDomain videoDomain) {
        userVideoDao.updateUserLikeOrCollectOrScore(videoDomain);
    }


    /**
     * 获取单个视频集合的浏览数、点赞数、收藏数、评分
     *
     * @param videoId
     * @return
     */

    @Override
    public List<Object> getLikeCollectScore(String videoId) {
        //0 浏览数量  1 获取点赞数   2获取收藏数    3获取评分
        UserVideoDomain u = userVideoDao.getLSC(videoId);
        List<Object> lcs = new LinkedList<Object>();
        int num = userVideoDao.getAloneVideoUserLook(videoId);//浏览单个视频的浏览数量
        int r = userVideoDao.getAloneVideoUserLookGroup(videoId);//浏览单个视频的用户量
        Double s = 0.0;
        if (u == null) {
            lcs.add(num);
            lcs.add(0);
            lcs.add(0);
        } else {
            lcs.add(num);
            lcs.add(u.getLike());
            lcs.add(u.getCollect());
            s = u.getScore();//获取评分
        }
        Double pf = 0.0;
        if (s > 0) {
            pf = s / r; //评分
        }
        lcs.add(pf);
        return lcs;
    }

    @Override
    public UserVideoDomain getLSC(String videoId) {
        return userVideoDao.getLSC(videoId);
    }

    @Override
    public void updateUserByUserId(UserDomain userDomain) {
        userVideoDao.updateUserByUserId(userDomain);
    }

    @Override
    public UserDomain getUserById(String id) {
        return userVideoDao.getUserById(id);
    }

}
