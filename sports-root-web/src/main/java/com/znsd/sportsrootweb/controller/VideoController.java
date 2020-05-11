package com.znsd.sportsrootweb.controller;

import com.znsd.sportsbean.user.UserDomain;
import com.znsd.sportsbean.util.Base64Utils;
import com.znsd.sportsbean.util.PageRequest;
import com.znsd.sportsbean.util.PageResult;
import com.znsd.sportsbean.video.VideoDomain;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/server/video")
public class VideoController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public VideoDomain add(@RequestParam("img_file") MultipartFile f1, @RequestParam("video_file") MultipartFile f2, String name, Double price, String userId, String typeId, String dec, @RequestParam(value = "integral", required = false) Integer integral) throws IOException {
        System.out.println(f1.getSize());
        System.out.println(f2.getSize());


        MultiValueMap map1 = new LinkedMultiValueMap();
        MultiValueMap map2 = new LinkedMultiValueMap();
        VideoDomain videoDomain = new VideoDomain();
        videoDomain.setId(UUID.randomUUID().toString());
        videoDomain.setName(name);
        int i1 = f1.getOriginalFilename().lastIndexOf(".");
        String fileName1 = videoDomain.getId() + f1.getOriginalFilename().substring(i1, f1.getOriginalFilename().length());
        int i2 = f2.getOriginalFilename().lastIndexOf(".");

        String fileName2 = videoDomain.getId() + f2.getOriginalFilename().substring(i2, f2.getOriginalFilename().length());


        map1.add("file", Base64Utils.getBase64FromInputStream(f1.getInputStream()));
        map1.add("fileName", fileName1);
        map2.add("base64", Base64Utils.getBase64FromInputStream(f2.getInputStream()));
        map2.add("fileName", fileName2);

        videoDomain.setPrice(price);
        videoDomain.setDec(dec);
        videoDomain.setUserId(userId);
        videoDomain.setTypeId(typeId);
        videoDomain.setImage(fileName1);
        videoDomain.setVideo(fileName2);

        if (integral != null) {
            videoDomain.setIntegral(integral);
        }


        System.out.println("//////" + videoDomain);

        restTemplate.postForObject("http://192.168.1.10:7999/uploadImage", map1, Boolean.class);
        restTemplate.postForObject("http://192.168.1.10:8001/addVideo", map2, Boolean.class);
        VideoDomain video = restTemplate.postForObject("http://192.168.1.10:8001/uploadVideo", videoDomain, VideoDomain.class);
        if (video.getId() != null) {
            restTemplate.postForObject("http://localhost:8008/commodity/video", video, String.class);
        }

        return video;
    }


    @GetMapping("/list")
    public PageResult getList(Integer page, Integer limit) throws JSONException {
        PageResult pageResult = restTemplate.getForObject("http://192.168.1.10:8001/findAllVideoNoStatus?pageNum=" + page + "&pageSize=" + limit, PageResult.class);
        return pageResult;
    }

    @PostMapping("/update")
    public boolean update(VideoDomain videoDomain) {
        System.out.println(videoDomain);
        restTemplate.postForObject("http://192.168.1.10:8001/updateVideoField", videoDomain, PageResult.class);
        return true;
    }

    @PostMapping("/delete")
    public boolean delete(String id) {
        System.out.println(id);
        restTemplate.getForObject("http://192.168.1.10:8001/deleteVideo?id=" + id, boolean.class);
        return true;
    }

}
