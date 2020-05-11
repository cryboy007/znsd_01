package com.znsd.sportslog.controller;

import com.alibaba.fastjson.JSONException;
import com.znsd.sportsbean.log.EchartsDomain;
import com.znsd.sportslog.service.EchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/echarts")
public class EchartsController {
    @Autowired
    private EchartsService echartsService;

    @GetMapping("/echart")
    public List<EchartsDomain> getList() throws JSONException {
        return echartsService.getList();
    }

    /**
     * 获取近7天用户观看视频分类饼图
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/echartBin")
    public List<EchartsDomain> getBin() throws JSONException {
        System.out.println(echartsService.getBin());
        return echartsService.getBin();
    }
}
