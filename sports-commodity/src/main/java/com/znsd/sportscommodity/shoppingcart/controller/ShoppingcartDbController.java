package com.znsd.sportscommodity.shoppingcart.controller;

import com.alibaba.fastjson.JSON;
import com.znsd.sportsbean.commodity.OrderDomain;
import com.znsd.sportsbean.commodity.ShoppingDomain;
import com.znsd.sportsbean.user.UserDomain;
import com.znsd.sportscommodity.shoppingcart.service.ShoppingcartDbService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * (ShoppingcartDb)表控制层
 *
 * @author makejava
 * @since 2020-05-04 19:11:47
 */
@RestController
@RequestMapping("shoppingcartDb")
public class ShoppingcartDbController {
    /**
     * 服务对象
     */
    @Resource
    private ShoppingcartDbService shoppingcartDbService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ShoppingDomain selectOne(String id) {
        return this.shoppingcartDbService.queryById(id);
    }

    /**
     * 获取所有数据
     *
     * @param offset 行
     * @param limit  列
     * @return
     */

    @GetMapping
    public List<ShoppingDomain> queryAll(int offset, int limit) {
        return this.shoppingcartDbService.queryAllByLimit(offset, limit);
    }

    /**
     * id自动生成 传对象增加
     *
     * @param shoppingDomain
     */

    @PostMapping
    public int insert(ShoppingDomain shoppingDomain) {
        shoppingDomain.setId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        return this.shoppingcartDbService.insert(shoppingDomain);
    }

    /**
     * 前台传id后台删除
     *
     * @param id 对象id
     * @return 无
     */

    @DeleteMapping
    public void delete(String id) {
        this.shoppingcartDbService.deleteById(id);
    }


    /**
     * 前台传对象后台修改
     *
     * @param shoppingDomain 对象
     * @return 无
     */

    @PutMapping
    public void update(ShoppingDomain shoppingDomain) {
        System.out.println(shoppingDomain);
        this.shoppingcartDbService.update(shoppingDomain);
    }


    /**
     * 通过用户名查询购物车中的商品
     *
     * @param userId 用户id
     * @return 商品信息
     */
    @GetMapping("userCommodity")
    public List<ShoppingDomain> getUserCommodity(String userId) {

        return this.shoppingcartDbService.getUserCommodity(userId);
    }


}