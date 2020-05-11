package com.znsd.sportslog.controller;

import com.github.pagehelper.PageInfo;
import com.znsd.sportsbean.log.SystemLogDomain;
import com.znsd.sportslog.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogController {
    @Autowired
    ActionService actionService;

    /**
     * 返回所有日志
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("logAll")
    @ResponseBody
    public PageInfo<SystemLogDomain> all(int page, int limit) {
        return actionService.selectAll(page, limit);
    }

    /**
     * 按日志bean所需字段动态查询
     *
     * @param page
     * @param limit
     * @param systemLogDomain
     * @return
     */
    @RequestMapping("logBy")
    @ResponseBody
    public PageInfo<SystemLogDomain> logBy(int page, int limit, SystemLogDomain systemLogDomain) {
        return actionService.selectTiao(page, limit, systemLogDomain);
    }

    /**
     * 获取今日登录成功数量
     */
    @CrossOrigin(origins = "*")
    @ResponseBody
    @RequestMapping("logUserUp")
    public int getUserUpSum() {
        return actionService.getUserUpSum();
    }

    /**
     * 获取昨日登录成功数量
     */
    @CrossOrigin(origins = "*")
    @ResponseBody
    @RequestMapping("logUserUpZT")
    public int getUserUpSumZT() {
        return actionService.getUserUpSumZT();
    }

    /**
     * 获取全部用户数量
     */
    @CrossOrigin(origins = "*")
    @ResponseBody
    @RequestMapping("logUserSum")
    public int getUserSum() {
        return actionService.getUserSum();
    }

    /**
     * 获取用户月活跃数量
     */
    @CrossOrigin(origins = "*")
    @ResponseBody
    @RequestMapping("logUserHuo")
    public int getUserHuo() {
        return actionService.getUserHuo();
    }

    /**
     * 获取今日盈利流水
     */
    @CrossOrigin(origins = "*")
    @ResponseBody
    @RequestMapping("getShuiNow")
    public double getShuiNow() {
        double shuiNow = actionService.getShuiNow();
        if (shuiNow == 0) {
            return 0;
        } else {
            return shuiNow;
        }
    }

    /**
     * 获取本月盈利流水
     */
    @CrossOrigin(origins = "*")
    @ResponseBody
    @RequestMapping("getShuiMon")
    public double getShuiMon() {
        double shuiNow = 0;
        shuiNow = actionService.getShuiMon();
        System.out.println(actionService.getShuiMon());
        if (shuiNow == 0) {
            return 0;
        } else {
            return shuiNow;
        }
    }

    /**
     * 获取视频总数量
     */
    @CrossOrigin(origins = "*")
    @ResponseBody
    @RequestMapping("logVoidSum")
    public int logVoidSum() {
        return actionService.logVoidSum();
    }
}
