package com.znsd.sportsvideo.controller;

import com.znsd.sportsbean.util.PageRequest;
import com.znsd.sportsbean.util.PageResult;
import com.znsd.sportsbean.video.VideoDomain;
import com.znsd.sportsbean.video.VideoTypeDomain;
import com.znsd.sportsvideo.service.VideoService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VideoController2 {
    //以下方法以2结尾的是不分页的
    @Autowired
    private VideoService2 videoService;

    /**
     * 查询所有视频集合
     *
     * @return
     */
    @RequestMapping(value = "/findPage")
    @ResponseBody
    public PageResult findPage(PageRequest pageQuery) {
        return videoService.findPage(pageQuery);
    }


    @RequestMapping(value = "/findPage2")
    @ResponseBody
    public List<VideoDomain> findPage2() {
        return videoService.findPage2();
    }

    /**
     * 获取所有视频（分页） 所有状态
     *
     * @param pageRequest
     * @return
     */
    @RequestMapping(value = "/findAllVideoNoStatus")
    @ResponseBody
    public PageResult findAllVideoNoStatus(PageRequest pageRequest) {
        return videoService.findAllVideoNoStatus(pageRequest);
    }

    /**
     * 根据集合视频的字段获取集合视频
     *
     * @param vd
     * @return
     */
    @RequestMapping("/findField")
    @ResponseBody
    public PageResult findByField(PageRequest pageQuery, VideoDomain vd) {
        return videoService.findVideoByField(pageQuery, vd);
    }

    @RequestMapping("/findField2")
    @ResponseBody
    public List<VideoDomain> findByField2(VideoDomain vd) {
        System.out.println(vd + "-----" + vd.getUserId());
        return videoService.findVideoByField2(vd);
    }


    /**
     * 模糊查询
     *
     * @return
     */
    @RequestMapping("/findLike")
    @ResponseBody
    public PageResult findBylike(PageRequest pageQuery, String string) {
        return videoService.findVideoConllectionStr(pageQuery, string);
    }

    @RequestMapping("/findLike2")
    @ResponseBody
    public List<VideoDomain> findBylike2(String string) {
        return videoService.findVideoConllectionStr2(string);
    }

    /**
     * 查询所有集合类型(没有分页)
     *
     * @return
     */
    @RequestMapping("/findType")
    @ResponseBody
    public List<VideoTypeDomain> findAllType() {
        return videoService.findAllType();
    }

    /**
     * 获取单个视频
     */
    @RequestMapping("/findVideoById")
    @ResponseBody
    public VideoDomain findVideoById(String videoId) {
        return videoService.findVideoById(videoId);
    }

    ;

    /**
     * 根据用户Id获取视频  状态为非禁用的
     */
    @RequestMapping("/findVideoList")
    @ResponseBody
    public List<VideoDomain> findVideoList(String userId) {
        return videoService.findVideoList(userId);
    }

    /**
     * 根据用户Id获与状态 获取视频
     */
    @RequestMapping("/findUserVideoListStatus")
    @ResponseBody
    public List<VideoDomain> findUserVideoListStatus(VideoDomain videoDomain) {
        return videoService.findUserVideoListStatus(videoDomain);
    }

    /**
     * 修改单个视频  必须传视频编号
     */
    @PostMapping("/updateVideoField")
    @ResponseBody
    public void updateVideoField(@RequestBody VideoDomain videoDomain) {
        System.out.println(videoDomain);
        videoService.updateVideoField(videoDomain);
    }

}
