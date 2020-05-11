package com.znsd.sportsvideo.dao;

import com.znsd.sportsbean.video.VideoDomain;

import java.util.List;

public interface VideoDao {


    /**
     * 上传视频
     *
     * @param videoDomain
     * @return
     */
    public void insertVideo(VideoDomain videoDomain);


    /**
     * 根据视频合集编号获取该视频合集里的视频
     *
     * @param collId
     * @return
     */
    public List<VideoDomain> getAllVideoById(String collId);

    /**
     * 修改视频表信息
     *
     * @param videoDomain
     * @return
     */
    public void updateVideo(VideoDomain videoDomain);

    /**
     * 删除视频合集
     *
     * @param id
     * @return
     */
    public void deleteColl(String id);


    /**
     * 删除视频
     *
     * @param id
     * @return
     */
    public void deleteVideo(String id);

}
