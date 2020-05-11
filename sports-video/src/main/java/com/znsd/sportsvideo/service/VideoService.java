package com.znsd.sportsvideo.service;

import com.znsd.sportsbean.video.VideoDomain;

import java.util.List;

public interface VideoService {


    /**
     * 上传视频
     *
     * @param videoDomain
     * @return
     */
    public VideoDomain insertVideo(VideoDomain videoDomain);


    /**
     * 修改视频表信息
     *
     * @param videoDomain
     * @return
     */
    public void updateVideo(VideoDomain videoDomain);


    /**
     * 删除视频
     *
     * @param id
     * @return
     */
    public void deleteVideo(String id);

}
