package com.znsd.sportsbean.video;

import java.util.Date;
import java.util.List;

/**
 * 订阅表（subscribe_db），和视频集合表（video_collection），用户表（user_db）关联
 */
public class SubscribeDomain {
    private String id;//订阅编号
    private String videoId;//订阅视频集合编号
    private String userId;//订阅用户编号
    private Date times;

    private List<VideoDomain> videoDomain; //视频表

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public List<VideoDomain> getVideoDomain() {
        return videoDomain;
    }

    public void setVideoDomain(List<VideoDomain> videoDomain) {
        this.videoDomain = videoDomain;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "SubscribeDomain{" +
                "id='" + id + '\'' +
                ", videoId='" + videoId + '\'' +
                ", userId='" + userId + '\'' +
                ", times=" + times +
                ", videoDomain=" + videoDomain +
                '}';
    }
}
