package com.znsd.sportsvideo.controller;

import com.znsd.sportsbean.video.VideoDomain;
import com.znsd.sportsvideo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:8001",allowCredentials = "true")
@Controller
public class VideoController {

    @Autowired
    private VideoService videoService;


    /**
     * 上传视频
     *
     * @param videoDomain
     * @return
     */
    @PostMapping("/uploadVideo")
    @ResponseBody
    public VideoDomain insertVideo(@RequestBody VideoDomain videoDomain) {
        System.out.println(videoDomain);
        return videoService.insertVideo(videoDomain);
    }


    /**
     * 修改视频表信息
     *
     * @param videoDomain
     * @return
     */
    @PostMapping("/updateVideo")
    @ResponseBody
    public void updateVideo(VideoDomain videoDomain) {
        videoService.updateVideo(videoDomain);
    }

    /**
     * 删除视频
     *
     * @param id
     * @return
     */
    @GetMapping("/deleteVideo")
    @ResponseBody
    public void deleteVideo(String id) {
        videoService.deleteVideo(id);
    }

}
