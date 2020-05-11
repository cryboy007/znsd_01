package com.znsd.sportsrootweb.controller;

import com.github.pagehelper.PageInfo;
import com.znsd.sportsbean.commodity.CommodityType2Domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/server/commodityType")
public class CommodityTypeController {

    @Autowired
    public RestTemplate restTemplate;

    @Value("${commodity.server}")
    private String commodityPath;

    @GetMapping("/list")
    public List<CommodityType2Domain> getList() {
        return restTemplate.getForObject(commodityPath + "commodityType/commodityTypeAllNoPage", List.class);
    }

}
