package com.znsd.sportsmallweb.url.config;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class MyController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/test")
    public boolean sss(@RequestParam("img") MultipartFile multipartFile, String imageId) throws IOException {
        int i = multipartFile.getOriginalFilename().lastIndexOf(".");
        String fileName = imageId + multipartFile.getOriginalFilename().substring(i, multipartFile.getOriginalFilename().length());
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
