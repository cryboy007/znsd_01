package com.znsd.sportsvideo.dao;

import com.znsd.sportsbean.user.UserDomain;
import com.znsd.sportsbean.user.UserVideoDomain;
import com.znsd.sportsbean.video.VideoDomain;

import java.util.List;

public interface UserVideoDao {


    /**
     * 获取该用户所有视频集合的点赞量
     *
     * @param userId
     * @return
     */
    public Integer getLikeNumber(String userId);

    /**
     * 获取该用户所有视频集合的收藏量
     *
     * @param userId
     * @return
     */
    public Integer getCollectNumber(String userId);

    /**
     * 根据字段查询
     * 返回单个视频集合里的点赞数\评论数\收藏数
     */
    public Integer getAloneField(UserVideoDomain videoDomain);

    /**
     * *****************************对单个视频集合的操作******************************************
     */
    /**
     * 必须传入视频集合编号,
     * 查询看过该集合视频的人数（浏览数量）
     */
    public Integer getAloneVideoUserLook(String collId);

    /**
     * 必须传入视频集合编号,
     * 查询看过该集合视频的人数（去重）
     */
    public Integer getAloneVideoUserLookGroup(String collId);

    /**
     * 获取单个视频集合的总评分
     *
     * @param collId
     * @return
     */
    public Double getAloneVideoScore(String collId);

    /**
     * 必须传入用户id,和视频集合id
     * 查询用户对单个视频的操作
     */
    public UserVideoDomain getUserAloneVideo(UserVideoDomain videoDomain);

    /**
     * 增加用户对单个视频集合的点赞，收藏、评分
     */
    public void addUserLikeAndCollectAndScore(UserVideoDomain videoDomain);

    /**
     * 修改对单个视频集合  点赞/收藏/评分
     *
     * @param videoDomain
     */
    public void updateUserLikeOrCollectOrScore(UserVideoDomain videoDomain);

    /**
     * 获取单个视频的总点赞和总收藏和总评分
     *
     * @param videoId
     * @return
     */
    public UserVideoDomain getLSC(String videoId);

    /**
     * 根据用户id修改用户（可修改积分、money）
     */
    public void updateUserByUserId(UserDomain userDomain);

    /**
     * 根据id获取用户
     */
    public UserDomain getUserById(String id);

}
