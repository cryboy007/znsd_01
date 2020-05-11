package com.znsd.sportsvideo.service.impl;

import com.znsd.sportsbean.video.SubscribeDomain;
import com.znsd.sportsvideo.dao.SubscribeDao;
import com.znsd.sportsvideo.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscribeServiceImpl implements SubscribeService {
    @Autowired
    private SubscribeDao subscribeDao;

    /**
     * 添加一条订阅
     *
     * @param subscribeDomain
     */
    public SubscribeDomain insertSubscribe(SubscribeDomain subscribeDomain) {
        subscribeDao.insertSubscribe(subscribeDomain);
        return subscribeDomain;
    }


    /**
     * 判断并得到这个视频是否已订阅 , videoId,userId
     *
     * @param subscribeDomain
     */
    public Integer getSubscribe(SubscribeDomain subscribeDomain) {
        Integer subscribe = subscribeDao.getSubscribe(subscribeDomain);
        return subscribe;
    }
}
