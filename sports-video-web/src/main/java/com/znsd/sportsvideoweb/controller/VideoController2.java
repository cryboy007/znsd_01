package com.znsd.sportsvideoweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.znsd.sportsbean.user.UserDomain;
import com.znsd.sportsbean.user.UserVideoDomain;
import com.znsd.sportsbean.util.PageRequest;
import com.znsd.sportsbean.util.PageResult;

import com.znsd.sportsbean.video.SubscribeDomain;
import com.znsd.sportsbean.video.VideoCommentDomain;
import com.znsd.sportsbean.video.VideoDomain;
import com.znsd.sportsbean.video.VideoTypeDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class VideoController2 {
    @Autowired
    RestTemplate restTemplate;

    /**
     * 查询所有视频(分页)
     *
     * @return
     */
    @RequestMapping("/findPage")
    public String findPage(PageRequest pageRequest, Map<String, Object> map) {
        PageResult pageResult = restTemplate.getForObject("http://localhost:8001/findPage", PageResult.class, pageRequest);
        map.put("videoDomain", pageResult.getContent());
        return "startVideo";
    }

    /**
     * 查询所有视频集合(不分页)
     *
     * @return
     */
    @RequestMapping("/findPage2")
    @ResponseBody
    public List<VideoDomain> findPage() {
        List<VideoDomain> forObject = restTemplate.getForObject("http://localhost:8001/findPage2", List.class);
        return forObject;
    }


    /**
     * 根据集合视频的字段获取集合视频（分页）
     *
     * @param
     * @return
     */
    @RequestMapping("/findField")
    public String findbyId2(PageRequest pageQuery, Map<String, Object> map) {
        PageResult pageResult = restTemplate.getForObject("http://localhost:8001/findField?pageNum=" + 0 + "&pageSize=" + 10 + "&userId=90ac537f619b4ee6b878e8de3f005f95", PageResult.class);
        map.put("videoDomain", pageResult.getContent());
        map.put("pageNum", pageResult.getPageNum());
        map.put("pageSize", pageResult.getPageSize());
        return "videoAdmin";
    }

    /**
     * 根据集合视频的字段获取集合视频（不分页）
     * @param vd
     * @return
     */
   /* @RequestMapping("/findField2")
    public String findByField2(VideoDomain vd,Map<String,Object> map){
        List<VideoDomain> videoDomains = restTemplate.getForObject("http://localhost:8001/findField2?userId="+vd.getUserId(), List.class);
        map.put("videoDomain",videoDomains);
        return "videoAdmin";
    }*/

    /**
     * 查询该用户发的所有视频
     *
     * @param userId
     * @param map
     * @return
     */
    @RequestMapping("/findVideoList")
    public String findVideoList(String userId, Map<String, Object> map) {
        userId = "f";
        List<VideoDomain> videoDomains = restTemplate.getForObject("http://localhost:8001/findVideoList?userId=" + userId, List.class);
        map.put("videoDomain", videoDomains);
        return "videoAdmin";
    }

    /**
     * 根据用户Id获与状态 获取视频
     */
    @RequestMapping("/findUserVideoListStatus")
    public String findUserVideoListStatus(VideoDomain videoDomain, Map<String, Object> map) {
        videoDomain.setUserId("f");
        List<VideoDomain> videoDomains = restTemplate.getForObject("http://localhost:8001/findUserVideoListStatus?userId=" + videoDomain.getUserId() + "&status=" + videoDomain.getStatus(), List.class);
        map.put("videoDomain", videoDomains);
        return "videoAdmin";
    }

    /**
     * 获取单个视频
     */
    @RequestMapping("/findVideoById")
    @ResponseBody
    public ModelAndView findVideoById(String videoId, ModelAndView view) {
        VideoDomain videoDomain = restTemplate.getForObject("http://localhost:8001/findVideoById?videoId=" + videoId, VideoDomain.class);
        view.addObject("videoDomain", videoDomain);
        view.setViewName("updateVideo");
        System.out.println(videoDomain.toString() + "---");
        return view;
    }

    ;

    /**
     * 模糊查询(分页)
     * string 获取输入的值
     *
     * @return
     */
    @RequestMapping("/findLike")
    public String findBylike(PageRequest pageQuery, String string, Map<String, Object> map) {
        PageResult pageResult = restTemplate.getForObject("http://localhost:8001/findLike?pageNum=0&pageSize=10&string=" + string, PageResult.class, pageQuery, string);
        map.put("videoDomain", pageResult.getContent());
        return "startVideo";
    }

    /**
     * 模糊查询(不分页)
     * string 获取输入的值
     *
     * @return
     */
    @RequestMapping("/findLike2")
    @ResponseBody
    public List<VideoDomain> findBylike2(String string) {
        List<VideoDomain> videoDomains = restTemplate.getForObject("http://localhost:8001/findLike2?string=" + string, List.class, string);
        return videoDomains;
    }

    /**
     * 查询所有集合类型(没有分页)
     *
     * @return
     */
    @PostMapping("/findType")
    @ResponseBody
    public List<VideoTypeDomain> findAllType() {
        List<VideoTypeDomain> videoTypeDomains = restTemplate.getForObject("http://localhost:8001/findType", List.class);
        return videoTypeDomains;
    }


    /**
     * 获取单个视频
     */
    @RequestMapping("/findVideoById/{videoId}")
    public String findVideoById(@PathVariable(value = "videoId") String videoId, Map<String, Object> map) {
        //获取视频
        VideoDomain videoDomain = restTemplate.getForObject("http://localhost:8001/findVideoById?videoId=" + videoId, VideoDomain.class);

        //获取导师
        UserDomain userDomain = restTemplate.getForObject("http://localhost:8002/query?id=" + videoDomain.getUserId(), UserDomain.class);

        //获取当前登录的用户
        UserDomain userDomain2 = restTemplate.getForObject("http://localhost:8002/query?id=" + "cfcf6830-bb7a-4e88-b1d8-97ef2dbac011", UserDomain.class);


        //获取总点赞，总收藏，总播放
        List list = restTemplate.getForObject("http://localhost:8001/getLikeCollectScore?videoId=" + videoId, List.class);

        Integer number = restTemplate.getForObject("http://localhost:8001/getCommonNumber?userId=" + userDomain.getId(), Integer.class);
        //获取评论集合
        PageResult pageResult = restTemplate.getForObject("http://localhost:8001/getAloneConllectCommon?pageNum=" + 0 + "&pageSize=" + 20 + "&videoId=" + videoDomain.getId(), PageResult.class);
        String s = "http://localhost:8001/addUserLikeAndCollectAndScore?videoId=" + videoId + "&userId=" + userDomain.getId();
        //获取评论，收藏，播放
        UserVideoDomain userVideoDomain = restTemplate.getForObject(s, UserVideoDomain.class);
        String s2 = "http://localhost:8001/getSubscribe?videoId=" + videoDomain.getId() + "?userId=" + userDomain2.getId();
        Object forObject = restTemplate.getForObject(s2, Object.class);
        System.out.println(forObject + ".....................");
        map.put("status", forObject);
        map.put("videoDomain", videoDomain);
        map.put("userDomain", userDomain);
        map.put("userDomain2", userDomain2);
        map.put("list", list);
        map.put("number", number);
        map.put("videoCommentDomain", pageResult.getContent());
        map.put("userVideoDomain", userVideoDomain);
        return "playVideo";
    }

    ;

    /**
     * 根据字段查询
     */
    @GetMapping("/findVideoByField")
    @ResponseBody
    public String findVideoByField(PageRequest pageQuery, Map<String, Object> map, VideoDomain v) {
        ModelAndView modelAndView = new ModelAndView();
        String str = "";
        if (("全部").equals(v.getTypeId())) {
            v.setTypeId(null);
        }
        if (v.getTypeId() != null) {
            System.out.println("----------" + v.getTypeId());
            str = "&typeId=" + v.getTypeId();
        }
        if (v.getPrice() != null) {
            System.out.println("************");
            str = str + "&price=" + v.getPrice();
        }
        PageResult pageResult = restTemplate.getForObject("http://localhost:8001/findField?pageNum=" + 0 + "&pageSize=" + 10 + str, PageResult.class);
        String s = JSONObject.toJSONString(pageResult);
        return s;
    }


}
