package com.znsd.sportsmallweb.url.controller;

import com.znsd.sportsbean.commodity.ShoppingDomain;
import com.znsd.sportsbean.user.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class ShopController {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("addShopcat")
    @ResponseBody
    public int addShopcat(String id, int number, HttpServletRequest request) {
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        try {
            UserDomain user = (UserDomain) request.getSession().getAttribute("user");
            ShoppingDomain[] shop = restTemplate.getForObject("http://localhost:8008/shoppingcartDb/userCommodity?userId=" + user.getId(), ShoppingDomain[].class);
            int index = -1;

            List<ShoppingDomain> list = Arrays.asList(shop);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getCommodityid().equals(id)) {
                    index = i;
                }
            }
            if (index != -1) {
                ShoppingDomain shoppingDomain = list.get(index);

                shoppingDomain.setNumber(shoppingDomain.getNumber() + number);
                paramMap.add("id", shoppingDomain.getId());
                paramMap.add("userId", shoppingDomain.getUserId());
                paramMap.add("commodityid", shoppingDomain.getCommodityid());
                paramMap.add("number", shoppingDomain.getNumber());
                System.out.println("----" + shoppingDomain.getNumber());
                restTemplate.put("http://localhost:8008/shoppingcartDb", paramMap);
            } else {
                paramMap.add("id", null);
                paramMap.add("userId", user.getId());
                paramMap.add("commodityid", id);
                paramMap.add("number", number);
                int i = restTemplate.postForObject("http://localhost:8008/shoppingcartDb", paramMap, Integer.class);
            }
            return 1;
        } catch (NullPointerException e) {
            return 0;
        }
    }

}
