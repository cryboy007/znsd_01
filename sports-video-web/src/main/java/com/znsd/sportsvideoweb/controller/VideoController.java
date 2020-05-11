package com.znsd.sportsvideoweb.controller;


import com.znsd.sportsbean.video.VideoDomain;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class VideoController {

    @Autowired
    private RestTemplate restTemplate;
    private static String image = null;
    private static String video = null;

    /**
     * 上传视频
     *
     * @param videoDomain
     * @return
     */
    @PostMapping("/uploadVideo")
    public String insertVideo(VideoDomain videoDomain, ModelAndView modelAndView) {
        videoDomain.setVideo(video);
        videoDomain.setImage(image);
        String s = "http://localhost:8001/uploadVideo?name=" + videoDomain.getName() + "&video=" + videoDomain.getVideo() + "&image=" + videoDomain.getImage() + "&typeId=" + videoDomain.getTypeId() + "&dec=" + videoDomain.getDec() + "&price=" + videoDomain.getPrice() + "&integral=" + videoDomain.getIntegral() + "&userId=" + videoDomain.getUserId();
        VideoDomain forObject = restTemplate.getForObject(s, VideoDomain.class);
        modelAndView.addObject("videoDomain", videoDomain);

        return "addVideo.html";
    }


    /**
     * 修改视频表信息
     *
     * @param videoDomain
     * @return
     */
    @PostMapping("/updateVideo")
    @ResponseBody
    public ModelAndView updateVideo(VideoDomain videoDomain, ModelAndView modelAndView) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("name", videoDomain.getName());
        map.add("typeId", videoDomain.getTypeId());
        map.add("id", videoDomain.getId());
        map.add("dec", videoDomain.getDec());
        map.add("integral", videoDomain.getIntegral());
        HttpEntity requestBody = new HttpEntity(map, headers);
        restTemplate.postForObject("http://localhost:8001/updateVideo", map, String.class);
        modelAndView.setViewName("redirect:findVideoList");
        return modelAndView;
    }

    /**
     * 删除视频
     *
     * @param id
     * @return
     */
    @GetMapping("/deleteVideo")
    public ModelAndView deleteVideo(String id, ModelAndView modelAndView) {
        restTemplate.getForObject("http://localhost:8001/deleteVideo?id=" + id, "".getClass());
        modelAndView.setViewName("redirect:findVideoList");
        return modelAndView;
    }


//

    @RequestMapping("/uploadFile")
    public String uploadFile(HttpServletRequest request, Map<String, String> map) throws IOException {
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartHttpServletRequest.getFile("file");
        int i = multipartFile.getOriginalFilename().lastIndexOf(".");
        String fileName = UUID.randomUUID().toString() + multipartFile.getOriginalFilename().substring(i, multipartFile.getOriginalFilename().length());
        MultiValueMap<String, String> map1 = new LinkedMultiValueMap<>();
        InputStream inputStream = multipartFile.getInputStream();
        String base64 = getBase64FromInputStream(inputStream);
        map1.add("file", base64);// 添加文件到表单
        map1.add("fileName", fileName);
        System.out.println(fileName);
        restTemplate.postForObject("http://192.168.1.10:8006/uploadImage", map1, boolean.class);
        image = fileName;
        return "addVideo.html";
    }


    public static String getBase64FromInputStream(InputStream in) {
        // 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;
        // 读取图片字节数组
        try {
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[100];
            int rc = 0;
            while ((rc = in.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            data = swapStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new String(Base64.encodeBase64(data));
    }

    @RequestMapping("/uploadFile2")
    @ResponseBody
    public String eee(@RequestParam("multipartFile") MultipartFile multipartFile, HttpServletResponse response) throws IOException {
        int i = multipartFile.getOriginalFilename().lastIndexOf(".");
        String fileName = UUID.randomUUID().toString() + multipartFile.getOriginalFilename().substring(i, multipartFile.getOriginalFilename().length());
        InputStream inputStream = multipartFile.getInputStream();
        String base64 = getBase64FromInputStream(inputStream);
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("base64", base64);
        param.add("fileName", fileName);
        inputStream.close();
        String string = restTemplate.postForObject("http://192.168.1.10:8001/testUp2", param, String.class);
        System.out.println(fileName);
        video = fileName;
        response.setStatus(200);
        String json = "{\n" +
                "  \"code\": 0\n" +
                "  ,\"msg\": \"\"\n" +
                "  ,\"data\": {\n" +
                "    \"src\": \"http://cdn.layui.com/123.jpg\"\n" +
                "  }\n" +
                "}";
        return json;
    }


}
