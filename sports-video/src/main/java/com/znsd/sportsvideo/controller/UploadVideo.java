package com.znsd.sportsvideo.controller;

import com.znsd.sportsbean.video.VideoDomain;
import com.znsd.sportsvideo.service.VideoService;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.Base64;

@RestController
public class UploadVideo {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/addVideo", method = RequestMethod.POST)
    public boolean upload(String base64, String fileName) throws Exception {
        System.out.println("base64" + base64);
        System.out.println("fileName" + fileName);
        byte[] decode = Base64.getDecoder().decode(base64);
        File f2 = new File("D:/Program Files/sports/video/" + fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(f2);
        fileOutputStream.write(decode);
        fileOutputStream.close();
        System.out.println(f2.getPath());
        return true;
    }

}
