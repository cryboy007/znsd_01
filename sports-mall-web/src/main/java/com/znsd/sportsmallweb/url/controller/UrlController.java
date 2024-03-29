package com.znsd.sportsmallweb.url.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.znsd.sportsbean.commodity.CommodityAndTypeDomain;
import com.znsd.sportsbean.commodity.CommodityDomain;
import com.znsd.sportsbean.commodity.OrderDomain;
import com.znsd.sportsbean.commodity.ShoppingDomain;
import com.znsd.sportsbean.user.UserAddressDomain;
import com.znsd.sportsbean.user.UserDomain;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class UrlController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("index")
    public String index() {
        return "index.html";
    }


    @RequestMapping("demo")
    public String demo() {
        return "demo.html";
    }

    @RequestMapping("men")
    public String men() {
        return "shop.html";
    }

    @GetMapping("login")
    public String login() {
        return "login.html";
    }

    @GetMapping("queryMen")
    public String men(String typeId, HttpServletRequest request) {
        List<CommodityAndTypeDomain> list = restTemplate.getForObject("http://localhost:8008/commodity/queryTypeCommodityAll?typeId=" + typeId, List.class);
        request.setAttribute("list", list);
        request.setAttribute("type", list.get(0));
        return "shop.html";
    }

    @GetMapping("queryName")
    public String queryName(String name, HttpServletRequest request) {
        List<CommodityAndTypeDomain> list = restTemplate.getForObject("http://localhost:8008/commodity/getName?name=" + name, List.class);
        request.setAttribute("list", list);
        return "queryShop.html";
    }


    @GetMapping("image")
    public String image() {
        return "image.html";
    }

    @RequestMapping("single")
    public String single(String id, HttpServletRequest request) {

        CommodityAndTypeDomain commodityAndTypeDomain = restTemplate.getForObject("http://localhost:8008/commodity/queryCommodityAndType?id=" + id, CommodityAndTypeDomain.class);
        request.setAttribute("commodity", commodityAndTypeDomain);
        System.out.println(commodityAndTypeDomain);
        try {
            UserDomain user = (UserDomain) request.getSession().getAttribute("user");
            MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
            paramMap.add("id", UUID.randomUUID().toString().replace("-", "").toLowerCase());
            paramMap.add("userId", user.getId());
            paramMap.add("commodityId", commodityAndTypeDomain.getId());
            paramMap.add("times", null);
            paramMap.add("typeId", commodityAndTypeDomain.getTypeId());
            paramMap.add("typeName", commodityAndTypeDomain.getTypeName());
            System.out.println(paramMap);
        } catch (NullPointerException e) {
            return "single.html";
        }
        return "single.html";
    }

    @GetMapping("shoppingcart")
    public String shoppingcart(HttpServletRequest request) {

        UserDomain user = (UserDomain) request.getSession().getAttribute("user");
        try {
            List<ShoppingDomain> list = restTemplate.getForObject("http://localhost:8002/shopCat?userid=" + user.getId(), List.class);
            request.setAttribute("shopList", list);
            System.out.println(list + "-------------");
        } catch (NullPointerException e) {
            request.setAttribute("msg", "请登录ok?");

            return "index.html";
        }
        return "shoppingcart.html";
    }


    @GetMapping("denglu")
    public String denglu(String userName, String password, HttpServletRequest request) {
        UserDomain userDomain = restTemplate.getForObject("http://localhost:8008/login/yz?userName=" + userName + "&password=" + password, UserDomain.class);
        System.out.println(userDomain);
        if (userDomain == null) {
            request.setAttribute("pwdError", "密码错误");
            return "login.html";
        }
        request.getSession().setAttribute("user", userDomain);
        List<UserAddressDomain> addresList = restTemplate.getForObject("http://localhost:8002/Qaddress?userid=" + userDomain.getId(), List.class);
        request.getSession().setAttribute("address", addresList);
        return "index.html";
    }

    @GetMapping("zf")
    public String zf(int money) {
        return null;
    }

    @GetMapping("shopCommodity")
    public String shopCommodity(List list) {
        System.out.println(list);
        return "shopCOmmodity.html";
    }

    @GetMapping("getAddress")
    @ResponseBody
    public List<UserAddressDomain> getAddress(HttpServletRequest request) {
        UserDomain user = (UserDomain) request.getSession().getAttribute("user");
        System.out.println(user + "---------------");
        List<UserAddressDomain> list = null;
        try {
            list = restTemplate.getForObject("http://localhost:8002/Qaddress?userid=" + user.getId(), List.class);
        } catch (NullPointerException e) {
            return null;
        }
        return list;
    }

    @GetMapping("goumai")
    @ResponseBody
    public int goumai(String shopid, int money, int count, int address, HttpServletRequest request) {

//        获取用户信息
        UserDomain user = (UserDomain) request.getSession().getAttribute("user");
//            获取收货地址
        UserAddressDomain userAddressDomain = restTemplate.getForObject("http://localhost:8002//queryAddressId?addressId=" + address, UserAddressDomain.class);
        //获取购物车商品对象
        ShoppingDomain shoppingDomain = restTemplate.getForObject("http://localhost:8008/shoppingcartDb/selectOne?id=" + shopid, ShoppingDomain.class);
        CommodityDomain commodityDomain = restTemplate.getForObject("http://localhost:8008/commodity/selectOne?id=" + shoppingDomain.getCommodityid(), CommodityDomain.class);
        //当用户余额小于总余额时
        if (user.getMoney() < money) {
//            user.getMoney()<money
            return -1;
        } else {
            MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
            //删除购物车商品

            paramMap.add("userId", user.getId());
            paramMap.add("commodityId", commodityDomain.getId());
            paramMap.add("status", 0);
            paramMap.add("address", userAddressDomain.getAddress());
            double sum = commodityDomain.getPrice() * count;
            paramMap.add("money", sum);
            paramMap.add("number", count);
            //增加到订单表

            boolean blag = restTemplate.postForObject("http://localhost:8008/orderDb/insert", paramMap, boolean.class);
            restTemplate.delete("http://localhost:8008/shoppingcartDb?id=" + shopid);

            MultiValueMap<String, Object> userMap = new LinkedMultiValueMap<String, Object>();
            userMap.add("userId", user.getId());
            double num = (user.getMoney() - (commodityDomain.getPrice() * count));
            userMap.add("money", num);
            int i = restTemplate.postForObject("http://localhost:8002//updateMoney", userMap, Integer.class);
            //返回商品价格
            Double moneyShop = commodityDomain.getPrice() * count;
            Integer shopdemo = moneyShop.intValue();
            return shopdemo;
        }

    }

    @GetMapping("delete")
    @ResponseBody
    public void deleteCart(String id) {
        restTemplate.delete("http://localhost:8008/shoppingcartDb?id=" + id);
    }

    @GetMapping("order")
    public String order(HttpServletRequest request) {
        UserDomain user = (UserDomain) request.getSession().getAttribute("user");
        try {
            List<OrderDomain> list = restTemplate.getForObject("http://localhost:8008/orderDb/queryOrderUserId?userId=" + user.getId(), List.class);
            request.setAttribute("orderList", list);
        } catch (NullPointerException e) {
            request.setAttribute("msg", "请登录ok?");
            return "index.html";
        }
        return "order.html";
    }


    @GetMapping("like")
    public String like(HttpServletRequest request) {
        UserDomain user = (UserDomain) request.getSession().getAttribute("user");
        List<CommodityAndTypeDomain> list = restTemplate.getForObject("http://localhost:8003/likeShop?userid=" + user.getId(), List.class);
        request.setAttribute("list", list);
        System.out.println(list);
        return "shop.html";
    }


}
