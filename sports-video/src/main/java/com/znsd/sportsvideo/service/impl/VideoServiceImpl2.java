package com.znsd.sportsvideo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.znsd.sportsbean.user.UserVideoDomain;
import com.znsd.sportsbean.util.PageRequest;
import com.znsd.sportsbean.util.PageResult;
import com.znsd.sportsbean.util.PageUtils;
import com.znsd.sportsbean.util.TimeUtils;
import com.znsd.sportsbean.video.VideoDomain;
import com.znsd.sportsbean.video.VideoTypeDomain;
import com.znsd.sportsvideo.dao.UserVideoDao;
import com.znsd.sportsvideo.dao.VideoDao2;
import com.znsd.sportsvideo.service.VideoService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class VideoServiceImpl2 implements VideoService2 {
    @Autowired
    private VideoDao2 videoDao;
    @Autowired
    private UserVideoDao userVideoDao;


    @Override
    public PageResult findPage(PageRequest pageRequest) {
        PageResult pr = PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
        List<VideoDomain> videoDomains = (List<VideoDomain>) pr.getContent();
        for (VideoDomain v : videoDomains) {
            UserVideoDomain u = userVideoDao.getLSC(v.getId());
            if (u == null) {
                v.setTotalCollect(0);
                v.setTotalLike(0);
                int r = userVideoDao.getAloneVideoUserLookGroup(v.getId());//浏览单个视频的用户量
                v.setTotalSocre(0.0);
                v.setTotalBrowse(r);
            } else {
                v.setTotalCollect(u.getCollect());
                v.setTotalLike(u.getLike());
                int r = userVideoDao.getAloneVideoUserLookGroup(v.getId());//浏览单个视频的用户量
                if (u.getScore() == null) {
                    v.setTotalSocre(0.0);
                } else {
                    v.setTotalSocre(u.getScore() / r);
                }

                v.setTotalBrowse(r);
            }


        }
        return pr;
    }

    @Override
    public List<VideoDomain> findPage2() {
        return videoDao.findPage();
    }

    @Override
    public PageResult findAllVideoNoStatus(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, findAllVideoNoStatusPageInfo(pageRequest));
    }


    @Override
    public PageResult findVideoByField(PageRequest pageRequest, VideoDomain videoDomain) {
        return PageUtils.getPageResult(pageRequest, getPagebyFiled(pageRequest, videoDomain));
    }

    @Override
    public List<VideoDomain> findVideoByField2(VideoDomain videoDomain) {
        return videoDao.findVideoByField(videoDomain);
    }

    @Override
    public PageResult findVideoConllectionStr(PageRequest pageRequest, String name) {

        return PageUtils.getPageResult(pageRequest, getPagebyLiek(pageRequest, name));
    }

    /**
     * 模糊查询不分页
     *
     * @param string
     * @return
     */
    @Override
    public List<VideoDomain> findVideoConllectionStr2(String string) {
        return videoDao.findVideoStr(string);
    }

    @Override
    public List<VideoTypeDomain> findAllType() {
        return videoDao.findAllType();
    }

    @Override
    public VideoDomain findVideoById(String videoId) {
        return videoDao.findVideoById(videoId);
    }

    @Override
    public List<VideoDomain> findVideoList(String userId) {
        List<VideoDomain> videoDomains = videoDao.findVideoList(userId);
        for (VideoDomain v : videoDomains) {
            publicFind(v);
        }
        return videoDomains;
    }

    @Override
    public List<VideoDomain> findUserVideoListStatus(VideoDomain videoDomain) {
        List<VideoDomain> videoDomains = videoDao.findUserVideoListStatus(videoDomain);
        for (VideoDomain v : videoDomains) {
            publicFind(v);
        }
        return videoDomains;
    }

    @Override
    public void updateVideoField(VideoDomain videoDomain) {
        videoDao.updateVideoField(videoDomain);
    }

    public void pagehelper(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
    }

    /**
     * 调用分页插件完成分页(根据字段模糊查询所有)
     *
     * @param
     * @return
     */
    private PageInfo<VideoDomain> getPagebyLiek(PageRequest pageRequest, String string) {
        pagehelper(pageRequest);
        List<VideoDomain> find = videoDao.findVideoStr(string);
        return new PageInfo<VideoDomain>(find);
    }


    /**
     * 调用分页插件完成分页(根据字段查询所有)
     *
     * @param
     * @return
     */
    private PageInfo<VideoDomain> getPagebyFiled(PageRequest pageRequest, VideoDomain videoDomain) {
       /* int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
         PageHelper.startPage(pageNum, pageSize);*/
        pagehelper(pageRequest);
        List<VideoDomain> find = videoDao.findVideoByField(videoDomain);
        return new PageInfo<VideoDomain>(find);
    }

    /**
     * 调用分页插件完成分页(查询所有)
     *
     * @param
     * @return
     */
    private PageInfo<VideoDomain> getPageInfo(PageRequest pageRequest) {
        pagehelper(pageRequest);
        List<VideoDomain> find = videoDao.findPage();
        return new PageInfo<VideoDomain>(find);
    }

    private PageInfo<VideoDomain> findAllVideoNoStatusPageInfo(PageRequest pageRequest) {
        pagehelper(pageRequest);
        List<VideoDomain> find = videoDao.findAllVideoNoStatus();
        return new PageInfo<VideoDomain>(find);
    }

    private void publicFind(VideoDomain v) {
        UserVideoDomain u = userVideoDao.getLSC(v.getId());
        if (u == null) {
            v.setTotalCollect(0);
            v.setTotalLike(0);
            int r = userVideoDao.getAloneVideoUserLookGroup(v.getId());//浏览单个视频的用户量
            v.setTotalSocre(0.0);
            v.setTotalBrowse(r);
        } else {
            v.setTotalCollect(u.getCollect());
            v.setTotalLike(u.getLike());
            int r = userVideoDao.getAloneVideoUserLookGroup(v.getId());//浏览单个视频的用户量
            if (u.getScore() == null) {
                v.setTotalSocre(0.0);
            } else {
                v.setTotalSocre(u.getScore() / r);
            }
            v.setTotalBrowse(r);
        }


    }


}
