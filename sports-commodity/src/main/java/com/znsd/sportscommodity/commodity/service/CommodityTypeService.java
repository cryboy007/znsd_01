package com.znsd.sportscommodity.commodity.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.znsd.sportsbean.commodity.CommodityType2Domain;
import com.znsd.sportsbean.commodity.CommodityTypeDomain;
import com.znsd.sportscommodity.commodity.dao.CommodityTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommodityTypeService {
    @Autowired
    CommodityTypeDao commodityTypeDao;

    public PageInfo<CommodityType2Domain> getTypeAll(int page, int limit) {
        PageHelper.startPage(page, limit);
        List<CommodityType2Domain> list = commodityTypeDao.getTypeAll();
        PageInfo<CommodityType2Domain> pageaa = new PageInfo<>(list);
        return pageaa;
    }

    public Boolean deleteType(String commodityid) {
        int row = commodityTypeDao.deleteType(commodityid);
        return row != -1 ? true : false;
    }

    public Boolean updateType(CommodityType2Domain commodityType) {
        int row = commodityTypeDao.updateType(commodityType);
        return row != -1 ? true : false;
    }

    public Boolean insetType(CommodityType2Domain commodityType) {
        commodityType.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        int row = commodityTypeDao.insetType(commodityType);
        return row != -1 ? true : false;
    }

    public List<CommodityType2Domain> getAll() {
        return commodityTypeDao.getTypeAll();
    }
}
