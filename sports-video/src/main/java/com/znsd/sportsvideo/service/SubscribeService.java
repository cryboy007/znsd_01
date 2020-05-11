package com.znsd.sportsvideo.service;

import com.znsd.sportsbean.video.SubscribeDomain;

public interface SubscribeService {
    /**
     * 添加一条订阅
     *
     * @param subscribeDomain
     */
    public SubscribeDomain insertSubscribe(SubscribeDomain subscribeDomain);


    /**
     * 判断并得到这个视频是否已订阅 , videoId,userId
     *
     * @param subscribeDomain
     */
    public Integer getSubscribe(SubscribeDomain subscribeDomain);
}
