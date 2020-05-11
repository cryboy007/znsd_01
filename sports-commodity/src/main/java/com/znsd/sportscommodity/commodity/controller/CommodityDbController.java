package com.znsd.sportscommodity.commodity.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.znsd.sportsbean.commodity.CommodityAndTypeDomain;
import com.znsd.sportsbean.commodity.CommodityAndVideoDomain;
import com.znsd.sportsbean.commodity.CommodityDomain;
import com.znsd.sportsbean.video.VideoDomain;
import com.znsd.sportscommodity.commodity.service.CommodityDbService;
import com.znsd.sportslog.annotation.SystemControllerLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * 商品
 * <p>
 * (CommodityDb)表控制层
 *
 * @author makejava
 * @since 2020-05-04 14:51:31
 */

@RestController
@RequestMapping("commodity")
public class CommodityDbController {
    /**
     * 服务对象
     */
    @Resource
    private CommodityDbService commodityDbService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CommodityDomain selectOne(String id) {
        return this.commodityDbService.queryById(id);
    }

    @GetMapping
    public PageInfo<CommodityDomain> queryAll(int page, int limit) {
        return this.commodityDbService.queryAllByLimit(page, limit);
    }


    @PostMapping
    public void insert(CommodityDomain commodityDomain) {
        commodityDomain.setInventory(0);
        commodityDomain.setSales(0);
        this.commodityDbService.insert(commodityDomain);
    }

    @DeleteMapping
    public void delete(String id) {
        this.commodityDbService.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody CommodityDomain commodityDomain) {
        this.commodityDbService.update(commodityDomain);
    }

    /**
     * 模糊查询商品
     *
     * @param name 商品名称
     * @return 商品集合
     */
    @GetMapping("getName")
    public List<CommodityDomain> getName(String name) {
        return this.commodityDbService.queryName(name);
    }

    /**
     * 模糊查询商品分页
     *
     * @param name 商品名称
     * @return 商品集合
     */
    @GetMapping("getNameLimit")
    public PageInfo<CommodityAndTypeDomain> getNameLimit(String name, int page, int limit) {
        return this.commodityDbService.getNameLimit(name, page, limit);
    }

    @GetMapping("querycommodityTypeDomain")
    public List<CommodityAndTypeDomain> querycommodityTypeDomain() {
        return this.commodityDbService.querycommodityDomain();
    }

    /**
     * 商品分页
     *
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("querycommodityTypeDomainByLimit")
    PageInfo<CommodityAndTypeDomain> querycommodityTypeDomainByLimit(int page, int limit) {
        return this.commodityDbService.querycommodityTypeDomainByLimit(page, limit);
    }

    ;

    /**
     * 分页重制版
     */
    @GetMapping("querycommodityTypeDomainByLimit2")
    PageInfo<CommodityAndTypeDomain> querycommodityTypeDomainByLimit2(int page, int limit) {
        return this.commodityDbService.querycommodityTypeDomainByLimit2(page, limit);
    }

    ;

    /**
     * 根据类型获取商品
     *
     * @param typeId 类型id
     * @return 商品集合
     */
    @CrossOrigin(origins = "*")
    @GetMapping("queryTypeCommodity")
    public PageInfo<CommodityAndTypeDomain> queryTypeCommodity(String typeId, int page, int limit) {
        return this.commodityDbService.queryTypeCommodity(typeId, page, limit);
    }

    @GetMapping("queryTypeCommodityAll")
    public List<CommodityAndTypeDomain> queryTypeCommodityAll(String typeId) {
        return this.commodityDbService.queryTypeCommodityAll(typeId);
    }

    /**
     * 查询单个商品
     *
     * @param id
     * @return
     */
    @GetMapping("queryCommodityAndType")
    public CommodityAndTypeDomain queryCommodityAndType(String id) {
        return this.commodityDbService.queryCommodityAndType(id);
    }


    @PostMapping("video")
    public void insertVideo(@RequestBody VideoDomain videoDomain) {
        CommodityDomain commodityDomain = new CommodityDomain();
        commodityDomain.setId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        commodityDomain.setName(videoDomain.getName());
        commodityDomain.setBewrite(videoDomain.getDec());
        commodityDomain.setPrice(videoDomain.getPrice());
        commodityDomain.setImage(videoDomain.getImage());
        commodityDomain.setInventory(0);
        commodityDomain.setSales(0);
        commodityDomain.setSum(9999);
        commodityDomain.setTypeId("4");
        this.commodityDbService.insert(commodityDomain);
        CommodityAndVideoDomain commodityAndVideoDomain = new CommodityAndVideoDomain();
        commodityAndVideoDomain.setCommodityid(commodityDomain.getId());
        commodityAndVideoDomain.setVideoid(videoDomain.getId());
        this.commodityDbService.insertVideo(commodityAndVideoDomain);
    }

}