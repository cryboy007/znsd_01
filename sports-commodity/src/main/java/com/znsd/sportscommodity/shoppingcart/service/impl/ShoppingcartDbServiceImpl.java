package com.znsd.sportscommodity.shoppingcart.service.impl;

import com.znsd.sportsbean.commodity.ShoppingDomain;
import com.znsd.sportscommodity.shoppingcart.dao.ShoppingcartDbDao;
import com.znsd.sportscommodity.shoppingcart.service.ShoppingcartDbService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ShoppingcartDb)表服务实现类
 *
 * @author makejava
 * @since 2020-05-04 19:11:46
 */
@Service("shoppingcartDbService")
public class ShoppingcartDbServiceImpl implements ShoppingcartDbService {
    @Resource
    private ShoppingcartDbDao shoppingcartDbDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ShoppingDomain queryById(String id) {
        return this.shoppingcartDbDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<ShoppingDomain> queryAllByLimit(int offset, int limit) {
        return this.shoppingcartDbDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param shoppingDomain 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(ShoppingDomain shoppingDomain) {

        return this.shoppingcartDbDao.insert(shoppingDomain);
    }

    /**
     * 修改数据
     *
     * @param shoppingDomain 实例对象
     * @return 实例对象
     */
    @Override
    public ShoppingDomain update(ShoppingDomain shoppingDomain) {
        this.shoppingcartDbDao.update(shoppingDomain);
        return this.queryById(shoppingDomain.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.shoppingcartDbDao.deleteById(id) > 0;
    }

    /**
     * 通过用户名查询购物车中的商品
     *
     * @param userId 用户id
     * @return 商品信息
     */
    @Override
    public List<ShoppingDomain> getUserCommodity(String userId) {
        return this.shoppingcartDbDao.getUserCommodity(userId);
    }
}