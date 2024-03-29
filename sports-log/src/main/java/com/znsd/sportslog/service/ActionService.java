package com.znsd.sportslog.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.znsd.sportsbean.commodity.CommodityAndTypeDomain;
import com.znsd.sportsbean.commodity.CommodityDomain;
import com.znsd.sportsbean.log.SystemLogDomain;
import com.znsd.sportsbean.user.UserDomain;
import com.znsd.sportslog.dao.LofMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActionService {
    @Autowired
    LofMapper lofMapper;

    public void add(SystemLogDomain action) {
        lofMapper.add(action);
    }

    public PageInfo<SystemLogDomain> selectAll(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<SystemLogDomain> list = lofMapper.selectAll();
        PageInfo<SystemLogDomain> pageaa = new PageInfo<>(list);
        return pageaa;
    }

    /**
     * 根据条件查询
     *
     * @param page
     * @param rows
     * @param systemLogDomain
     * @return
     */
    public PageInfo<SystemLogDomain> selectTiao(int page, int rows, SystemLogDomain systemLogDomain) {
        PageHelper.startPage(page, rows);
        List<SystemLogDomain> list = lofMapper.selectUserLog(systemLogDomain);
        PageInfo<SystemLogDomain> pageaa = new PageInfo<>(list);
        return pageaa;
    }

    /**
     * 查询该用户近7天浏览商品记录日志
     */
    public PageInfo<SystemLogDomain> logByUserShop(int page, int rows, String userid) {
        SystemLogDomain systemLogDomain = new SystemLogDomain();
        systemLogDomain.setUserid(userid);
        systemLogDomain.setBewrite("浏览商品");
        PageHelper.startPage(page, rows);
        List<SystemLogDomain> list = lofMapper.selectS(systemLogDomain);
        PageInfo<SystemLogDomain> pageaa = new PageInfo<>(list);
        return pageaa;
    }


    /**
     * 根据用户ID获取近7天浏览商品ID
     *
     * @return
     */
    public List<String> getCommodityDomain(int page, int rows, String userid) {
        List<SystemLogDomain> list = logByUserShop(page, rows, userid).getList();
        int listSize = list.size();
        List<String> userByShopIdList = new ArrayList<>();
        for (SystemLogDomain domain : list) {
            String can = domain.getParameter();
            int index = can.indexOf("id=");
            String shopId = can.substring(index + 3, index + 35);
            userByShopIdList.add(shopId);
        }
        return userByShopIdList;
    }

    /**
     * 根据用户ID获取近7天浏览商品详细
     */
//    public  List<CommodityAndTypeDomain> getCommodityAndTypeDomain(String userId){
//        List<String> shopIdList=getCommodityDomain(1,999,userId);
//        List<CommodityAndTypeDomain> list=restTemplate.getForObject("http://localhost:8008/commodity/querycommodityTypeDomain",List.class);
//        List<CommodityAndTypeDomain> list2=new ArrayList<>();
//        for (String s : shopIdList) {
//            for (CommodityAndTypeDomain commodityAndTypeDomain : list) {
//                if(commodityAndTypeDomain.getId().equals(s)){
//                    list2.add(commodityAndTypeDomain);
//                }
//            }
//        }
//        return list2;
//    }
    public int getUserUpSum() {
        return lofMapper.getUserUpSum();
    }

    public int getUserUpSumZT() {
        return lofMapper.getUserUpSumZT();
    }

    public int getUserSum() {
        return lofMapper.getUserSum();
    }

    public int getUserHuo() {
        return lofMapper.getUserHuo();
    }

    public double getShuiNow() {
        return lofMapper.getShuiNow();
    }

    public double getShuiMon() {
        return lofMapper.getShuiMon();

    }

    public int logVoidSum() {
        return lofMapper.logVoidSum();

    }
}
