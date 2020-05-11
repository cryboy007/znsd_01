package com.znsd.sportscommodity.order.controller;

import com.alibaba.fastjson.JSON;
import com.znsd.sportsbean.commodity.OrderDomain;
import com.znsd.sportscommodity.order.service.OrderDbService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * (OrderDb)表控制层
 *
 * @author makejava
 * @since 2020-05-04 19:28:52
 */
@RestController
@RequestMapping("orderDb")
public class OrderDbController {
    /**
     * 服务对象
     */
    @Resource
    private OrderDbService orderDbService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public OrderDomain selectOne(String id) {
        return this.orderDbService.queryById(id);
    }

    @GetMapping
    public List<OrderDomain> queryAll(int offset, int limit) {
        return this.orderDbService.queryAllByLimit(offset, limit);
    }

    @PostMapping("insert")
    public boolean insert(String userId, String commodityId, Integer status, double money, String address, Integer number) {
        OrderDomain orderDomain = new OrderDomain();
        orderDomain.setUserId(userId);
        orderDomain.setCommodityId(commodityId);
        orderDomain.setStatus(status);
        orderDomain.setAddress(address);
        orderDomain.setSum(money);
        orderDomain.setNumber(number);
        orderDomain.setTimes(null);
        orderDomain.setId(UUID.randomUUID().toString());
        this.orderDbService.insert(orderDomain);
        return true;
    }

    /**
     * 前台传id后台删除
     *
     * @param id 对象id
     * @return 无
     */

    @DeleteMapping
    public void delete(String id) {
        this.orderDbService.deleteById(id);
    }


    /**
     * 前台传id后台删除
     *
     * @param orderDomain 对象id
     * @return 无
     */

    @PutMapping
    public void update(OrderDomain orderDomain) {
        this.orderDbService.update(orderDomain);
    }

    /**
     * 查询订单跟用户,商品,商品类型关联查询
     *
     * @return
     */

    @GetMapping("queryOrder")
    public List<OrderDomain> queryOrder() {
        return this.orderDbService.queryOrder();
    }

    /**
     * 根据用户ID查询订单跟用户,商品,商品类型关联查询
     *
     * @return
     */
    @GetMapping("queryOrderUserId")
    public List<OrderDomain> queryOrderId(String userId) {
        return this.orderDbService.queryOrderId(userId);
    }


    /**
     * 根据用户名查询订单跟用户,商品,商品类型关联查询
     *
     * @return
     */
    @GetMapping("queryOrderName")
    public List<OrderDomain> queryOrderName(String username) {
        return this.orderDbService.queryOrderName(username);
    }
}