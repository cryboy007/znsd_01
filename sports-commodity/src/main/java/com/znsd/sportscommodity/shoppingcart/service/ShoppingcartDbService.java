package com.znsd.sportscommodity.shoppingcart.service;

import com.znsd.sportsbean.commodity.ShoppingDomain;

import java.util.List;

/**
 * (ShoppingDomain)表服务接口
 *
 * @author makejava
 * @since 2020-05-04 19:11:46
 */
public interface ShoppingcartDbService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShoppingDomain queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ShoppingDomain> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param ShoppingDomain 实例对象
     * @return 实例对象
     */
    int insert(ShoppingDomain ShoppingDomain);

    /**
     * 修改数据
     *
     * @param ShoppingDomain 实例对象
     * @return 实例对象
     */
    ShoppingDomain update(ShoppingDomain ShoppingDomain);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    /**
     * 通过用户名查询购物车中的商品
     *
     * @param userId 用户id
     * @return 商品信息
     */

    List<ShoppingDomain> getUserCommodity(String userId);
}