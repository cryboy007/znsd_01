package com.znsd.sportsvideo.dao;

import com.znsd.sportsbean.video.VideoDomain;
import com.znsd.sportsbean.video.VideoTypeDomain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoDao2 {

    /**
     * 分页查询所有视频合集(状态为1)
     */
    public List<VideoDomain> findPage();

    /**
     * 分页查询所有视频合集（所有的状态）
     */
    public List<VideoDomain> findAllVideoNoStatus();

    /**
     * 根据视频字段查询
     *
     * @param videoDomain
     * @return
     */
    public List<VideoDomain> findVideoByField(VideoDomain videoDomain);

    /**
     * 模糊查询
     *
     * @param
     * @return
     */
    public List<VideoDomain> findVideoStr(String string);

    /**
     * 查询所有视频类型
     *
     * @return
     */
    public List<VideoTypeDomain> findAllType();

    /**
     * 获取单个视频
     */
    public VideoDomain findVideoById(String videoId);

    /**
     * 根据用户id获取视频 状态不为2（非禁用的）
     */
    public List<VideoDomain> findVideoList(String userId);

    /**
     * 根据用户id 与 状态， 获取视频
     */
    public List<VideoDomain> findUserVideoListStatus(VideoDomain videoDomain);


    /**
     * 修改单个视频  必须传视频编号
     */
    public void updateVideoField(VideoDomain videoDomain);

}
