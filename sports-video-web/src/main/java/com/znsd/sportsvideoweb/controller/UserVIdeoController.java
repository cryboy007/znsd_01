package com.znsd.sportsvideoweb.controller;

import com.znsd.sportsbean.user.UserVideoDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserVIdeoController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 获取该用户所有视频集合的点赞量
     *
     * @param
     * @return
     */
    @GetMapping("/getLikeNumber")
    @ResponseBody
    public Integer getLikeNumber() {
        return restTemplate.getForObject("http://localhost:8001/getLikeNumber?userId=6b94707d7eef40d7b74f204bbaeca29f", Integer.class);
    }

    /**
     * 获取该用户所有视频集合的收藏量
     *
     * @param
     * @return
     */
    @GetMapping("/getCollectNumber")
    @ResponseBody
    public Integer getCollectNumber() {
        return restTemplate.getForObject("http://localhost:8001/getCollectNumber?userId=6b94707d7eef40d7b74f204bbaeca29f", Integer.class);
    }

    /**
     * 必须传视频videId
     * 根据字段查询
     * 返回单个视频集合里的点赞数
     */
    @GetMapping("/getAloneConllectlike")
    @ResponseBody
    public Integer getAloneConllectlikes(UserVideoDomain videoDomain) {
        System.out.println(videoDomain);
        String s = "http://localhost:8001/getAloneConllectlike?videoId=" + videoDomain.getVideoId() + "&like=" + videoDomain.getLike();
        return restTemplate.getForObject(s, Integer.class);
    }

    /**
     * 必须传视频collId
     * 根据字段查询
     * 返回单个视频集合里的\收藏数
     */
    @GetMapping("/getAloneConllectCollect")
    @ResponseBody
    public Integer getAloneConllectCollect(UserVideoDomain videoDomain) {
        System.out.println(videoDomain);
        String s = "http://localhost:8001/getAloneConllectlike?videoId=" + videoDomain.getVideoId() + "&collect=" + videoDomain.getCollect();
        return restTemplate.getForObject(s, Integer.class);
    }

    /**
     * 获取单个视频集合的浏览数、点赞数、收藏数、评分
     *
     * @param videoId
     * @return
     */
    @GetMapping("/getLikeCollectScore")
    @ResponseBody
    public List<Object> getLikeCollectScore(String videoId) {
        //0 浏览数量  1 获取点赞数   2获取收藏数    3获取评分
        return restTemplate.getForObject("http://localhost:8001/getLikeCollectScore?videoId=" + videoId, List.class);
    }

    /**
     * 必须传入用户id,和视频vedioId
     * 增加用户对单个视频集合的点赞，收藏、评分
     */
    @GetMapping("/addUserLikeAndCollectAndScore")
    public UserVideoDomain addUserLikeAndCollectAndScores(UserVideoDomain videoDomain) {
        String s = "http://localhost:8001/addUserLikeAndCollectAndScore?videoId=" + videoDomain.getVideoId() + "&userId=" + videoDomain.getVideoId();
        return restTemplate.getForObject(s, UserVideoDomain.class);
    }


    /**
     * 必须传入用户id,和视频集合id
     * 修改对单个视频集合  点赞/收藏/评分 （修改其一）
     *
     * @param videoDomain
     */
    @PostMapping("/updateUserLikeOrCollectOrScore")
    @ResponseBody
    public Double updateUserLikeOrCollectOrScores(UserVideoDomain videoDomain) {
        videoDomain.setUserId("6eeef258-91ae-4ee1-a941-b21da33378c9");
        String s = "http://localhost:8001/updateUserLikeOrCollectOrScore?videoId=" + videoDomain.getVideoId() + "&userId=" + videoDomain.getUserId() + "&score=" + videoDomain.getScore();
        restTemplate.getForObject(s, String.class);
        return videoDomain.getScore();
    }

    /**
     * 必须传入用户id,和视频集合id
     * 修改对单个视频集合  点赞/收藏/评分 （修改其一）
     *
     * @param videoDomain
     */
    @PostMapping("/updateUserLikeOrCollectOrScore2")
    @ResponseBody
    public Integer updateUserLikeOrCollectOrScores2(UserVideoDomain videoDomain) {
        videoDomain.setUserId("6eeef258-91ae-4ee1-a941-b21da33378c9");
        String s = "http://localhost:8001/updateUserLikeOrCollectOrScore?videoId=" + videoDomain.getVideoId() + "&userId=" + videoDomain.getUserId() + "&like=" + videoDomain.getLike();
        restTemplate.getForObject(s, String.class);
        return videoDomain.getLike();
    }

    /**
     * 必须传入用户id,和视频集合id
     * 修改对单个视频集合  点赞/收藏/评分 （修改其一）
     *
     * @param videoDomain
     */
    @PostMapping("/updateUserLikeOrCollectOrScore3")
    @ResponseBody
    public Integer updateUserLikeOrCollectOrScores3(UserVideoDomain videoDomain) {
        videoDomain.setUserId("6eeef258-91ae-4ee1-a941-b21da33378c9");
        String s = "http://localhost:8001/updateUserLikeOrCollectOrScore?videoId=" + videoDomain.getVideoId() + "&userId=" + videoDomain.getUserId() + "&collect=" + videoDomain.getCollect();
        restTemplate.getForObject(s, String.class);
        return videoDomain.getCollect();
    }


}
