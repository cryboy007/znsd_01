package com.znsd.sportscommodity.order.service;

import com.znsd.sportsbean.commodity.OrderDomain;

import java.util.List;

/**
 * (OrderDomain)表服务接口
 *
 * @author makejava
 * @since 2020-05-04 19:28:51
 */
public interface OrderDbService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderDomain queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<OrderDomain> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param OrderDomain 实例对象
     * @return 实例对象
     */
    OrderDomain insert(OrderDomain OrderDomain);

    /**
     * 修改数据
     *
     * @param OrderDomain 实例对象
     * @return 实例对象
     */
    OrderDomain update(OrderDomain OrderDomain);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    /**
     * 查询订单跟用户,商品,商品类型关联查询
     *
     * @return
     */

    List<OrderDomain> queryOrder();


    /**
     * 根据用户ID查询订单跟用户,商品,商品类型关联查询
     *
     * @return
     */
    List<OrderDomain> queryOrderId(String userId);

    /**
     * 根据用户名查询订单跟用户,商品,商品类型关联查询
     *
     * @return
     */
    List<OrderDomain> queryOrderName(String username);
}