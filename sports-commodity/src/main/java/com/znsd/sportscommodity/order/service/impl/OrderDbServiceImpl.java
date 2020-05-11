package com.znsd.sportscommodity.order.service.impl;

import com.znsd.sportsbean.commodity.OrderDomain;
import com.znsd.sportscommodity.order.dao.OrderDbDao;
import com.znsd.sportscommodity.order.service.OrderDbService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OrderDomain)表服务实现类
 *
 * @author makejava
 * @since 2020-05-04 19:28:52
 */
@Service("OrderDomainService")
public class OrderDbServiceImpl implements OrderDbService {
    @Resource
    private OrderDbDao OrderDomainDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OrderDomain queryById(String id) {
        return this.OrderDomainDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<OrderDomain> queryAllByLimit(int offset, int limit) {
        return this.OrderDomainDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param OrderDomain 实例对象
     * @return 实例对象
     */
    @Override
    public OrderDomain insert(OrderDomain OrderDomain) {
        this.OrderDomainDao.insert(OrderDomain);
        return OrderDomain;
    }

    /**
     * 修改数据
     *
     * @param OrderDomain 实例对象
     * @return 实例对象
     */
    @Override
    public OrderDomain update(OrderDomain OrderDomain) {
        this.OrderDomainDao.update(OrderDomain);
        return this.queryById(OrderDomain.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.OrderDomainDao.deleteById(id) > 0;
    }

    @Override
    public List<OrderDomain> queryOrder() {
        return this.OrderDomainDao.queryOrder();
    }

    /**
     * 根据用户ID查询订单跟用户,商品,商品类型关联查询
     *
     * @return
     */
    @Override
    public List<OrderDomain> queryOrderId(String userId) {
        return this.OrderDomainDao.queryOrderId(userId);
    }

    @Override
    public List<OrderDomain> queryOrderName(String username) {
        return this.OrderDomainDao.queryOrderName(username);
    }


}