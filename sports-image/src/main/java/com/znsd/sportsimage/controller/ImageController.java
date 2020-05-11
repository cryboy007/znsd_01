package com.znsd.sportsimage.controller;

import com.znsd.sportsbean.Image;
import com.znsd.sportsimage.utils.FTPUtil;
import jdk.internal.util.xml.impl.Input;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;

import org.springframework.http.HttpRequest;
import org.springframework.http.RequestEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.Request;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Base64;
import java.util.Map;

@RestController
public class ImageController {
    @Value("image.path")
    private String filePath;

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public boolean test(String file, String fileName) throws IOException {
        System.out.println("fileName:" + fileName);
        byte[] decode = Base64.getDecoder().decode(file);
        File f2 = new File("D:/Program Files/sports/images/" + fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(f2);
        System.out.println(f2.getPath());
        fileOutputStream.write(decode);
        fileOutputStream.close();
        FTPClient ftp = new FTPClient();
        try {
            ftp.setStrictReplyParsing(false);
            ftp.connect("127.0.0.1", 365);//设置地址和端口号
            ftp.login("sports", "sports");//用户名和密码
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);//上传文件类型 二进制文件
            int reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {//检查连接是否有效
                System.out.println("error");
                return false;
            }
            ftp.changeWorkingDirectory("/images");
            FileInputStream fis = new FileInputStream(f2);
            System.out.println("---" + fileName);
            ftp.storeFile(fileName, fis);//关键代码,把流持久化到硬盘上
            fileOutputStream.close();
            fis.close();
            fis.close();
            ftp.logout();
            ftp.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


}
