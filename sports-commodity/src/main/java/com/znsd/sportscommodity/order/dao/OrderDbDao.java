package com.znsd.sportscommodity.order.dao;

import com.znsd.sportsbean.commodity.OrderDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (OrderDomain)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-04 19:28:51
 */
public interface OrderDbDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderDomain queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<OrderDomain> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param OrderDomain 实例对象
     * @return 对象列表
     */
    List<OrderDomain> queryAll(OrderDomain OrderDomain);

    /**
     * 新增数据
     *
     * @param OrderDomain 实例对象
     * @return 影响行数
     */
    int insert(OrderDomain OrderDomain);

    /**
     * 修改数据
     *
     * @param OrderDomain 实例对象
     * @return 影响行数
     */
    int update(OrderDomain OrderDomain);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    /**
     * 查询订单跟用户,商品,商品类型关联查询
     *
     * @return
     */

    List<OrderDomain> queryOrder();

    /**
     * 根据用户名查询订单跟用户,商品,商品类型关联查询
     *
     * @return
     */
    public List<OrderDomain> queryOrderName(String username);

    /**
     * 根据用户ID查询订单跟用户,商品,商品类型关联查询
     *
     * @return
     */
    public List<OrderDomain> queryOrderId(String userId);
}