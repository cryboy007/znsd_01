package com.znsd.sportslog.dao;

import com.github.pagehelper.PageInfo;
import com.znsd.sportsbean.log.SystemLogDomain;
import com.znsd.sportsbean.user.UserDomain;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface LofMapper {
    /**
     * 日志添加
     *
     * @param action
     */
    @Insert("insert into systemlog_db(id,bewrite,type,parameter,userid,ip,logreturn) values (#{id},#{bewrite},#{type},#{parameter},#{userid},#{ip},#{logreturn})")
    void add(SystemLogDomain action);

    /**
     * 所有日志查询
     *
     * @return
     */
    List<SystemLogDomain> selectAll();

    /**
     * 用户条件日志查询
     *
     * @return
     */
    List<SystemLogDomain> selectUserLog(SystemLogDomain systemLogDomain);

    /**
     * 查询近7天
     *
     * @return
     */
    List<SystemLogDomain> selectS(SystemLogDomain systemLogDomain);


    int getUserUpSum();

    @Select("select count(*) from systemlog_db where (TO_DAYS( NOW( ) ) - TO_DAYS(times))<=1 and bewrite='用户登录' and logreturn != 'null';")
    int getUserUpSumZT();

    int getUserSum();

    int getUserHuo();

    double getShuiNow();

    double getShuiMon();

    int logVoidSum();
}
