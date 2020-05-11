package com.znsd.sportslog.service;

import com.znsd.sportsbean.commodity.CommodityAndTypeDomain;
import com.znsd.sportsbean.commodity.CommodityHistoryDomain;
import com.znsd.sportslog.dao.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class LikeService {
    @Autowired
    LikeMapper likeMapper;
    @Autowired
    ActionService actionService;

    /**
     * 喜好推荐
     *
     * @return
     */
    public HashSet<CommodityAndTypeDomain> getLikeShop(String userId) {
        List<CommodityHistoryDomain> list = likeMapper.getTypeSize(userId);
        HashSet<CommodityAndTypeDomain> set = new HashSet<>();
//        System.out.println(list);
//        List<CommodityAndTypeDomain> returnLike=new ArrayList<>();
        //根据数据库记录查出，前3浏览
        int shopCount = likeMapper.shopCount();
        System.out.println("总数" + shopCount);
        int[] cc = new int[12];
        int inde = 0;
        if (list.size() < 3) {
            //去掉查询全部商品返回
            int random = (int) (Math.random() * shopCount);
            while (set.size() < 12) {
                random = (int) (Math.random() * (shopCount + 100));
                while (random >= shopCount) {
                    random = (int) (Math.random() * (shopCount + 100));
                    System.out.println(random);
                }
                CommodityAndTypeDomain domain = likeMapper.randomShopAll(random);
                set.add(domain);
                System.out.println(set);
                System.out.println("多少" + set.size());
            }
            System.out.println(set);
        } else {
            //总展示商品
            int sum = 12;
            //一页12个商品
            //第一浏览40%展示 5，第二浏览30%展示 3 ，第三20% 2，其余展示其他10% 2
            //第一展览的商品类型总数
            int oneCount = likeMapper.conut(list.get(0).getTypeId());
            //第2展览的商品类型总数
            int twoCount = likeMapper.conut(list.get(1).getTypeId());
            //第3展览的商品类型总数
            int threeCount = likeMapper.conut(list.get(2).getTypeId());
            System.out.println("第一" + oneCount);
            System.out.println("第二" + twoCount);
            System.out.println("第三" + threeCount);
            //其他型个数
            int one = oneCount;
            int two = twoCount;
            int three = threeCount;
            int ta = 2;
            if (oneCount > 5) {
                oneCount = 5;
            }
            if (oneCount < 5) {
                ta += (5 - oneCount);   // 4  8  1 3
            }
            if (twoCount > 3) {
                twoCount = 3;
            }
            if (twoCount < 3) {
                ta += 3 - twoCount;
            }
            if (threeCount > 2) {
                threeCount = 2;
            }
            if (threeCount < 2) {
                ta += 2 - threeCount;
            }
            int random = (int) (Math.random() * shopCount);
            System.out.println("第一" + oneCount);
            System.out.println("第二" + twoCount);
            System.out.println("第三" + threeCount);
            System.out.println("ta" + ta);
            while (set.size() < 12) {
                if (set.size() < oneCount) {
                    random = (int) (Math.random() * (shopCount + 100));
                    while (random > one) {
                        random = (int) (Math.random() * (shopCount + 100));
                    }
                    CommodityAndTypeDomain domain = likeMapper.RandomShop(list.get(0).getTypeId(), random);
                    set.add(domain);
                } else if (set.size() < twoCount + oneCount) {
                    random = (int) (Math.random() * (shopCount + 100));
                    while (random > two) {
                        random = (int) (Math.random() * (shopCount + 100));
                    }
                    CommodityAndTypeDomain domain = likeMapper.RandomShop(list.get(1).getTypeId(), random);
                    set.add(domain);
                } else if (set.size() < threeCount + twoCount + oneCount) {
                    random = (int) (Math.random() * (shopCount + 100));
                    while (random > three) {
                        random = (int) (Math.random() * (shopCount + 100));
                    }
                    CommodityAndTypeDomain domain = likeMapper.RandomShop(list.get(2).getTypeId(), random);
                    set.add(domain);
                } else if (set.size() < threeCount + twoCount + oneCount + ta) {
                    random = (int) (Math.random() * (shopCount + 100));
                    while (random >= shopCount) {
                        random = (int) (Math.random() * (shopCount + 100));
                    }
                    CommodityAndTypeDomain domain = likeMapper.randomShopAll(random);
                    set.add(domain);
                }
                System.out.println(set);
                System.out.println("多少" + set.size());
            }
        }
        return set;
    }

    //
    public static boolean cheakIsRepeat(int[] array) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < array.length; i++) {
            hashSet.add(array[i]);
        }
        if (hashSet.size() == array.length) {
            return true;
        } else {
            return false;
        }
    }
}
