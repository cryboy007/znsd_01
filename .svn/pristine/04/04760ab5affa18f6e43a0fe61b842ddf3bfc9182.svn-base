package com.znsd.sportsrootweb.controller;

import com.github.pagehelper.PageInfo;
import com.znsd.sportsbean.commodity.CommodityAndTypeDomain;
import com.znsd.sportsbean.commodity.CommodityDomain;
import com.znsd.sportsbean.user.UserDomain;
import com.znsd.sportsbean.util.Base64Utils;
import com.znsd.sportsbean.util.PageResult;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/server/commodity")
public class CommodityController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${commodity.server}")
    private String commodityPath;

    @Value("${image.server}")
    private String imagePath;

    @GetMapping("/list")
    public PageInfo<CommodityAndTypeDomain> getList(Integer page, Integer limit) throws JSONException {
        System.out.println(commodityPath);
        System.out.println(page + "/" + limit);
        if (limit == null) {
            limit = 10;
        }
        return restTemplate.getForObject(commodityPath + "commodity/querycommodityTypeDomainByLimit2?page=" + page + "&limit=" + limit, PageInfo.class);
    }

    @RequestMapping("/add")
    @ResponseBody
    public boolean sss(MultipartFile file, CommodityDomain commodityDomain) throws IOException {
        System.out.println(commodityDomain);
        int i = file.getOriginalFilename().lastIndexOf(".");
        commodityDomain.setId(UUID.randomUUID().toString());
        String fileName = commodityDomain.getId() + file.getOriginalFilename().substring(i, file.getOriginalFilename().length());
        System.out.println(file.getSize());
        System.out.println(fileName);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        MultiValueMap<String, Object> map2 = new LinkedMultiValueMap<>();
        InputStream inputStream = file.getInputStream();
        String base64 = Base64Utils.getBase64FromInputStream(inputStream);
        System.out.println(base64);
        map.add("file", base64);// 添加文件到表单
        map.add("fileName", fileName);
        map2.add("id", commodityDomain.getId());
        map2.add("name", commodityDomain.getName());
        map2.add("bewrite", commodityDomain.getBewrite());
        map2.add("typeid", commodityDomain.getTypeId());
        map2.add("sum", commodityDomain.getSum());
        map2.add("price", commodityDomain.getPrice());
        map2.add("image", fileName);
        map2.add("typeId", commodityDomain.getTypeId());
        restTemplate.postForObject(commodityPath + "uploadImage", map, boolean.class);
        restTemplate.postForObject(imagePath + "commodity", map2, boolean.class);
        return true;
    }

    @PostMapping("/update")
    public boolean update(CommodityDomain commodityDomain) {
        System.out.println(commodityDomain);
        restTemplate.put(commodityPath + "commodity", commodityDomain);
        return true;
    }

    @PostMapping("/delete")
    public boolean delete(String id) {
        System.out.println("id=" + id);
        restTemplate.delete(commodityPath + "commodity?id={id}", id);
        return true;
    }


}
