package com.znsd.sportsvideoweb.controller;

import com.znsd.sportsbean.user.UserDomain;
import com.znsd.sportsbean.video.SubscribeDomain;
import com.znsd.sportsbean.video.VideoDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;

@Controller
public class SubscribeController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 添加一条订阅
     *
     * @param subscribeDomain
     */
    @PostMapping("insertSubscribe")
    public SubscribeDomain insertSubscribe(SubscribeDomain subscribeDomain) {
        String s = "http://localhost:8001/insertSubscribe?videoId=" + subscribeDomain.getVideoId() + "&userId=" + subscribeDomain.getUserId();
        SubscribeDomain subscribeDomain1 = restTemplate.getForObject(s, SubscribeDomain.class);
        return subscribeDomain1;
    }


    /**
     * 判断并得到这个视频是否已订阅 , videoId,userId
     *
     * @param subscribeDomain
     */
    @PostMapping("getSubscribe")
    public Integer getSubscribe(SubscribeDomain subscribeDomain) {
        String s = "http://localhost:8001/getSubscribe?videoId=" + subscribeDomain.getVideoId() + "&userId=" + subscribeDomain.getUserId();
        Integer forObject = restTemplate.getForObject(s, Integer.class);
        return forObject;
    }

    /**
     * 订阅视频
     */
    @PostMapping("/readVideo")
    @ResponseBody
    public ModelAndView readVideo(Double price, Double money, String integral, Double fukuan, String acthorId, String diko, String userId, String videoId, ModelAndView modelAndView) {
        System.out.println("price:" + price + "---money:" + money + "---integral:" + integral + "---fukuan:" + fukuan + "---acthorId:" + acthorId + "---diko:" + diko + "---userId:" + userId + "---videoId:" + videoId);
        int integral2 = Integer.parseInt(integral);
        //需要除的积分
        int out = (int) (price - fukuan) * 10;
        //用户需要削去积分
        int userOut = integral2 - out;
        //用户需要付款的钱 fukuan
        Double m = money - fukuan;//用户余额-付款金额
        //1.修改用户
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("id", userId);
        map.add("money", m);
        map.add("integral", userOut);
        String s2 = "http://localhost:8001/updateUserByUserId";
        restTemplate.postForObject(s2, map, String.class);
        if (fukuan != 0) {
            //获取作者用户
            UserDomain userDomain = restTemplate.getForObject("http://localhost:8001/getSingleUser?id=" + acthorId, UserDomain.class);
            //获取作者余额 给作者余额加钱
            Double am = userDomain.getMoney() + fukuan;
            //2.修改作者的金额
            restTemplate.getForObject("http://localhost:8001/updateUserByUserId?id=" + acthorId + "&money=" + am, UserDomain.class);
        }

        //3.增加订阅消息
        String s = "http://localhost:8001/insertSubscribe?videoId=" + videoId + "&userId=" + userId;
        SubscribeDomain subscribeDomain1 = restTemplate.getForObject(s, SubscribeDomain.class);
        //获取视频对象
        VideoDomain videoDomain = restTemplate.getForObject("http://localhost:8001/findVideoById?videoId=" + videoId, VideoDomain.class);
        modelAndView.setViewName("redirect:findVideoById/" + videoId);
        return modelAndView;
    }
}
