package com.znsd.sportscommodity.shoppingcart.dao;

import com.znsd.sportsbean.commodity.ShoppingDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (ShoppingcartDb)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-04 19:11:45
 */
public interface ShoppingcartDbDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShoppingDomain queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ShoppingDomain> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param shoppingDomain 实例对象
     * @return 对象列表
     */
    List<ShoppingDomain> queryAll(ShoppingDomain shoppingDomain);

    /**
     * 新增数据
     *
     * @param shoppingDomain 实例对象
     * @return 影响行数
     */
    int insert(ShoppingDomain shoppingDomain);

    /**
     * 修改数据
     *
     * @param shoppingDomain 实例对象
     * @return 影响行数
     */
    int update(ShoppingDomain shoppingDomain);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    /**
     * 通过用户名查询购物车中的商品
     *
     * @param userId 用户id
     * @return 商品信息
     */

    List<ShoppingDomain> getUserCommodity(String userId);
}