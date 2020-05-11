package com.znsd.sportsbean.video;

import com.znsd.sportsbean.user.UserDomain;

import java.util.Date;

/**
 * 视频评论表（videocomment_db），
 * 与视频集合表（(video_collection)）和用户表（user_db）关联
 */
public class VideoCommentDomain {
    private String id;//评论编号
    private String wid;//伪视频id
    private String userId;//评论用户编号
    private String videoId;//视频合集编号
    private String comment;//评论内容
    private Date times;//评论时间
    private UserDomain user;//用户对象

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public UserDomain getUser() {
        return user;
    }

    public void setUser(UserDomain user) {
        this.user = user;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    @Override
    public String toString() {
        return "VideoCommentDomain{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", videoId='" + videoId + '\'' +
                ", comment='" + comment + '\'' +
                ", times=" + times +
                ", user=" + user +
                '}';
    }
}
