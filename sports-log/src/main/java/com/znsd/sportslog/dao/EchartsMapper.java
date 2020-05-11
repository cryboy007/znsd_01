package com.znsd.sportslog.dao;

import com.znsd.sportsbean.log.EchartsDomain;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EchartsMapper {
    public List<EchartsDomain> getList();

    @Select(value = " SELECT   typeName NAME,COUNT(typeName) value\n" +
            "        FROM (\n" +
            "        SELECT a.`times`,a.`videoId`,b.`typeId` FROM videohistory_db a JOIN video_db b ON b.`id`=a.`videoId` WHERE DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= DATE(a.times)) c\n" +
            "        JOIN videotype_db d ON c.typeId =d.`id` GROUP BY typeName")
    @ResultType(value = EchartsDomain.class)
    List<EchartsDomain> getBin();
}
