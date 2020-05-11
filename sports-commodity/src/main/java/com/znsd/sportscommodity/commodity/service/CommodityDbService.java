package com.znsd.sportscommodity.commodity.service;

import com.github.pagehelper.PageInfo;
import com.znsd.sportsbean.commodity.CommodityAndTypeDomain;
import com.znsd.sportsbean.commodity.CommodityAndVideoDomain;
import com.znsd.sportsbean.commodity.CommodityDomain;
import com.znsd.sportsbean.video.VideoDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (CommodityDb)表服务接口
 *
 * @author makejava
 * @since 2020-05-04 14:51:30
 */
public interface CommodityDbService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CommodityDomain queryById(String id);

    /**
     * 查询多条数据
     *
     * @param page  查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    PageInfo<CommodityDomain> queryAllByLimit(int page, int limit);

    /**
     * 新增数据
     *
     * @param commodityDb 实例对象
     * @return 实例对象
     */
    CommodityDomain insert(CommodityDomain commodityDb);

    /**
     * 修改数据
     *
     * @param commodityDb 实例对象
     * @return 实例对象
     */
    CommodityDomain update(CommodityDomain commodityDb);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    /**
     * 查询所有商品(包含类型)
     *
     * @return
     */
    List<CommodityAndTypeDomain> querycommodityDomain();

    /**
     * 根据name判断是否存在
     *
     * @param name
     * @return
     */

    List<CommodityDomain> queryName(String name);

    PageInfo<CommodityAndTypeDomain> querycommodityTypeDomainByLimit(@Param("page") int page, @Param("limit") int limit);

    PageInfo<CommodityAndTypeDomain> queryTypeCommodity(String typeId, int page, int limit);

    /**
     * 查询全部重制分页版
     *
     * @param page
     * @param limit
     * @return
     */
    PageInfo<CommodityAndTypeDomain> querycommodityTypeDomainByLimit2(int page, int limit);

    /**
     * 模糊查询分页
     *
     * @param name
     * @param page
     * @param limit
     * @return 查询集合
     */
    public PageInfo<CommodityAndTypeDomain> getNameLimit(String name, int page, int limit);


    public CommodityAndTypeDomain queryCommodityAndType(String id);

    /**
     * 根据类型查商品 无分页
     *
     * @param typeId
     * @return
     */
    List<CommodityAndTypeDomain> queryTypeCommodityAll(String typeId);


    /**
     * 添加商品视频中间表
     *
     * @param videoDomain
     */
    public void insertVideo(CommodityAndVideoDomain commodityAndVideoDomain);
}