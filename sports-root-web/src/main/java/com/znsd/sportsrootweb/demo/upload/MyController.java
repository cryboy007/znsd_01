package com.znsd.sportsrootweb.demo.upload;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class MyController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("D:/Program Files/sports/temp/")
    private String tempPath;

    @RequestMapping("/test3")
    public boolean ppp(@RequestParam("video") MultipartFile mFile, @RequestParam("videoId") String videoId) throws IOException {
        int i = mFile.getOriginalFilename().lastIndexOf(".");
        String fileName = videoId + mFile.getOriginalFilename().substring(i, mFile.getOriginalFilename().length());
        InputStream inputStream = mFile.getInputStream();
        String base64 = getBase64FromInputStream(inputStream);
        System.out.println(base64);
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("base64", base64);
        param.add("fileName", fileName);
        inputStream.close();
        String string = restTemplate.postForObject("http://192.168.1.10:8001/testUp2", param, String.class);
        return true;
    }

    @RequestMapping("/test4")
    public Map<String, Object> pppp(@RequestParam("file") MultipartFile mFile, HttpServletResponse response) throws IOException {
        System.out.println(mFile.getSize());
        int i = mFile.getOriginalFilename().lastIndexOf(".");
        String fileName = UUID.randomUUID().toString() + mFile.getOriginalFilename().substring(i, mFile.getOriginalFilename().length());
        InputStream inputStream = mFile.getInputStream();
        String base64 = getBase64FromInputStream(inputStream);
        System.out.println(base64);
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("base64", base64);
        param.add("fileName", fileName);
        inputStream.close();
        boolean b = restTemplate.postForObject("http://192.168.1.10:8001/testUp2", param, boolean.class);
        response.setStatus(200);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        return map;
    }


    @RequestMapping("/test2")
    public boolean eee(@RequestParam("video") MultipartFile mFile, @RequestParam("videoId") String videoId) throws IOException {
        int i = mFile.getOriginalFilename().lastIndexOf(".");
        String fileName = videoId + mFile.getOriginalFilename().substring(i, mFile.getOriginalFilename().length());
        File file = new File(tempPath + mFile.getOriginalFilename());
        System.out.println(file.getPath());
        mFile.transferTo(file);
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("filePath", tempPath + mFile.getOriginalFilename());
        param.add("fileName", fileName);
        String string = restTemplate.postForObject("http://192.168.1.10:8001/testUp", param, String.class);
        return true;
    }

    @RequestMapping("/test")
    public boolean sss(@RequestParam("img") MultipartFile multipartFile, String userid) throws IOException {
        int i = multipartFile.getOriginalFilename().lastIndexOf(".");
        String fileName = userid + multipartFile.getOriginalFilename().substring(i, multipartFile.getOriginalFilename().length());
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        InputStream inputStream = multipartFile.getInputStream();
        String base64 = getBase64FromInputStream(inputStream);

        map.add("file", base64);// 添加文件到表单
        map.add("fileName", fileName);
        restTemplate.postForObject("http://127.0.0.1:7999/uploadImgage", map, boolean.class);
        return true;
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

}
