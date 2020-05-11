package com.znsd.sportsrootweb.controller;

import com.github.pagehelper.PageInfo;
import com.znsd.sportsbean.commodity.CommodityAndTypeDomain;
import com.znsd.sportsbean.log.EchartsDomain;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/server/echarts")
public class EchartsController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/echart")
    public List<EchartsDomain> getList() throws JSONException {
        return restTemplate.getForObject("http://192.168.1.10:8003/echarts/echart", List.class);
    }
}
