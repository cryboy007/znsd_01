package com.znsd.sportscommodity.getType.dao;

import com.znsd.sportsbean.commodity.CommodityTypeDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (CommodittypeDb)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-04 08:51:28
 */
public interface CommodittypeDbDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CommodityTypeDomain queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CommodityTypeDomain> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    List<CommodityTypeDomain> queryAll();

    /**
     * 新增数据
     *
     * @param commodityTypeDomain 实例对象
     * @return 影响行数
     */
    int insert(CommodityTypeDomain commodityTypeDomain);

    /**
     * 修改数据
     *
     * @param commodityTypeDomain 实例对象
     * @return 影响行数
     */
    int update(CommodityTypeDomain commodityTypeDomain);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}