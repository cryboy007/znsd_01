package com.znsd.sportscommodity.commodity.dao;

import com.github.pagehelper.PageInfo;
import com.znsd.sportsbean.commodity.CommodityType2Domain;
import com.znsd.sportsbean.commodity.CommodityTypeDomain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityTypeDao {
    public List<CommodityType2Domain> getTypeAll();

    public int deleteType(String commodityid);

    public int updateType(CommodityType2Domain commodityType);

    int insetType(CommodityType2Domain commodityType);
}
