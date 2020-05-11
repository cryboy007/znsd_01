package com.znsd.sportslog.service;

import com.znsd.sportsbean.log.EchartsDomain;
import com.znsd.sportslog.dao.EchartsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EchartsService {
    @Autowired
    public EchartsMapper echartsMapper;

    public List<EchartsDomain> getList() {
        return echartsMapper.getList();
    }

    ;

    public List<EchartsDomain> getBin() {
        return echartsMapper.getBin();
    }
}
