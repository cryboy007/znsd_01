package com.znsd.sportscommodity.getType.service;

import com.znsd.sportsbean.commodity.CommodityTypeDomain;

import java.util.List;

/**
 * (CommodittypeDb)表服务接口
 *
 * @author makejava
 * @since 2020-05-04 08:51:29
 */
public interface CommodittypeDbService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CommodityTypeDomain queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CommodityTypeDomain> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param commodityTypeDomain 实例对象
     * @return 实例对象
     */
    CommodityTypeDomain insert(CommodityTypeDomain commodityTypeDomain);

    /**
     * 修改数据
     *
     * @param commodityTypeDomain 实例对象
     * @return 实例对象
     */
    CommodityTypeDomain update(CommodityTypeDomain commodityTypeDomain);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param
     * @return 对象列表
     */
    List<CommodityTypeDomain> queryAll();

}