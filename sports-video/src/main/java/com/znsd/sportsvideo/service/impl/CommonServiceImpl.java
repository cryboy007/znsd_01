package com.znsd.sportsvideo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.znsd.sportsbean.util.PageRequest;
import com.znsd.sportsbean.util.PageResult;
import com.znsd.sportsbean.util.PageUtils;
import com.znsd.sportsbean.video.VideoCommentDomain;
import com.znsd.sportsvideo.dao.CommonDao;
import com.znsd.sportsvideo.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CommonDao commonDao;

    @Override
    public Integer getCommonNumber(String userId) {
        return commonDao.getCommonNumber(userId);
    }

    @Override
    public PageResult getAloneConllectCommon(PageRequest pageRequest, String collId) {
        return PageUtils.getPageResult(pageRequest, getAloneConllectCommons(pageRequest, collId));
    }

    @Override
    public VideoCommentDomain insertComment(VideoCommentDomain videoCommentDomain) {
        commonDao.insertComment(videoCommentDomain);
        return videoCommentDomain;
    }


    public void pagehelper(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
    }

    private PageInfo<VideoCommentDomain> getAloneConllectCommons(PageRequest pageRequest, String collId) {
        pagehelper(pageRequest);
        List<VideoCommentDomain> find = commonDao.getAloneConllectCommon(collId);
        return new PageInfo<VideoCommentDomain>(find);
    }
}
