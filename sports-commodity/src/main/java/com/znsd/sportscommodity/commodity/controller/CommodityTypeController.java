package com.znsd.sportscommodity.commodity.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.znsd.sportsbean.commodity.CommodityType2Domain;
import com.znsd.sportsbean.commodity.CommodityTypeDomain;
import com.znsd.sportscommodity.commodity.service.CommodityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commodityType")
public class CommodityTypeController {
    @Autowired
    CommodityTypeService commodityTypeService;

    /**
     * 返回全部类型
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/commodityTypeAll")
    public PageInfo<CommodityType2Domain> getTypeAll(int page, int limit) {
        return commodityTypeService.getTypeAll(page, limit);
    }

    /**
     * 无分页
     */
    @RequestMapping("/commodityTypeAllNoPage")
    public List<CommodityType2Domain> getAll() {
        return commodityTypeService.getAll();
    }

    /**
     * 删除
     *
     * @param commodityid 类型id
     * @return
     */
    @DeleteMapping("/deleteType")
    public Boolean deleteType(String commodityid) {

        return commodityTypeService.deleteType(commodityid);
    }

    /**
     * 根据id修改类型
     */

    @PutMapping("/updateType")
    public Boolean updateType(CommodityType2Domain commodityType) {
        return commodityTypeService.updateType(commodityType);
    }

    /**
     * 新增类型
     *
     * @param commodityType 只需要传入类型名称就行
     * @return
     */
    @PostMapping("/insetType")
    public Boolean insetType(CommodityType2Domain commodityType) {
        return commodityTypeService.insetType(commodityType);
    }
}
